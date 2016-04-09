package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.text.BadLocationException;

import gui.BIGNotepad;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class FastReader extends BIGNotepad {

	private BIGNotepad notepad;

	private FastReader(BIGNotepad notepad) {
		this.notepad = notepad;
		document = this.notepad.bigEdit.getStyledDocument();
	}

	public static FastReader valueOf(BIGNotepad pad) {
		return new FastReader(pad);
	}

	/**
	 * Fast Reader. <br>
	 * The doc.insertString(...) and bigEdit.setText() work just fine for small
	 * documents. But if the document has weird characters (like a *.jpg, or
	 * *.exe file would have) it will take a long time to open. <br>
	 * If the document exceeds 1Mb, it will also take a lot to read/display. But
	 * fastReader uses a MappedByteBuffer that makes things a lot faster! <br>
	 *
	 * @param textFile
	 *            text file to open (path)
	 * @return 0 for OK, -1 for BadLocationException, -2 for IOException and -3
	 *         for FileNotFoundException.
	 */
	public int fastReader(String textFile) {
		long fileLength;
		if (textFile != null) {
			try {
				raFile = new RandomAccessFile(textFile, "r");
				fileChannel = raFile.getChannel();
				fileLength = fileChannel.size();
			} catch (FileNotFoundException ex) {
				System.err.println(ex);
				return -3;
			} catch (IOException ex) {
				System.err.println(ex);
				return -2;
			}
		} else {
			System.err.println("[fastReader] File is null..");
			return -1;
		}
		// insert chunks of text into bigEdit document
		while (offset < fileLength) {
			// get the next chunk of text.
			buffer = nextBuffer(offset);
			// update position (offset)
			offset += buffer.capacity();

			// create String to insert in document.
			StringBuilder sb = new StringBuilder();
			while (buffer.hasRemaining()) {
				sb.append((char) buffer.get());
			}
			try {
				// append to document
				document.insertString(document.getLength(), sb.toString(), null);
			} catch (BadLocationException ex) {
				System.err.println(ex);
				return -1;
			}
		}
		/**
		 * Unless you reset the offset, the next file you try to open (assuming
		 * it is smaller than the previous) will not be read.
		 */
		offset = 0;
		return 0;
	}

	/**
	 * Next Buffer. <br>
	 * Called in a loop, by Fast Reader, while its offset is smaller than
	 * fileChannel size. Basically the file size. <br>
	 *
	 * @param position
	 *            offset in the fileChannel. This offset + the chunk length
	 *            results in the size of the text inserted at once, in bigEdit.
	 * @return a MappedByteBuffer - a chunk of text of a predefined size.
	 *         Default is 4096 bytes. This should be greater for files larger
	 *         than a few megabytes.
	 */
	private MappedByteBuffer nextBuffer(long position) {
		try {
			if (fileChannel != null || fileChannel.size() != position) {
				long chunkLength = LENGTH;
				if (fileChannel.size() - position < chunkLength) {
					chunkLength = fileChannel.size() - position;
				}
				return fileChannel.map(FileChannel.MapMode.READ_ONLY, offset, chunkLength);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return null;
	}

	private RandomAccessFile raFile;
	private FileChannel fileChannel;
	private MappedByteBuffer buffer;
	/**
	 * LENGTH is the chunk size of text fast reader inserts into bigEdit at
	 * once! This could be smaller (ie: 4096) or bigger.
	 */
	private final int LENGTH = 16248;
	private long offset = 0;

}
