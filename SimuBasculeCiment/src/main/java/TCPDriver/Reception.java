package TCPDriver;

import DataModel.TCPDataBufferIn;
import java.io.BufferedReader;
import java.io.IOException;

public class Reception extends Thread {

	private BufferedReader in;
	private TCPDataBufferIn databuff;

	public Reception(BufferedReader in) {
		this.in = in;
		this.databuff = new TCPDataBufferIn();
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (!databuff.isDataRdy()) {
					in.read(databuff.getBuffer());
					databuff.setBufftodataString();
					System.out.println(databuff.getData());
				} else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block

					}
				}
			} catch (IOException e) {
			}
		}
	}

	/**
	 * @return the data
	 */
	public TCPDataBufferIn getDataBuffer() {
		return databuff;
	}

	/**
	 * @param databuff
	 */
	public void setDataBuffer(TCPDataBufferIn databuff) {
		this.databuff = databuff;
	}
}
