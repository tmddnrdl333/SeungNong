import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SEOUL09_JUNGSEUNGWOOK {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "SEOUL09_JUNGSEUNGWOOK";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// 01. 홀 위치 재설정
				float[][] holes = new float[6][2];
				for (int i = 0; i < 6; i++) {
					if (HOLES[i][0] == 0)
						holes[i][0] = 5.73f / 2;
					else if (HOLES[i][0] == 254)
						holes[i][0] = 254 - 5.73f / 2;
					else
						holes[i][0] = HOLES[i][0];
					if (HOLES[i][1] == 0)
						holes[i][1] = 5.73f / 2;
					else if (HOLES[i][1] == 254)
						holes[i][1] = 254 - 5.73f / 2;
					else
						holes[i][1] = HOLES[i][1];
				}

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];

				// - 공 선택 코드
				// 수구와 목적구의 각도 vs 목적구와 홀의 각도
				float minA = 180f; // 두 각의 차의 최소
				int minIdx = 0; // 그 인덱스 (선택할 목적구)
				double r_t2h_f = 0;
				int alreadyin = 0;
				if (order == 1) { // 선공
					int[] targetI = { 1, 3, 5 };
					for (int i = 0; i < 3; i++) {
						if (balls[targetI[i]][0] == -1.0) { // 들어간 공 스킵
							alreadyin++;
							continue;
						}
						if (alreadyin < 2 && i == 2) {
							continue;
						}
						// 수구와 목적구의 각도
						double r_w2t = Math.atan2(balls[targetI[i]][0] - whiteBall_x,
								balls[targetI[i]][1] - whiteBall_y);
						float a_w2t = (float) ((180.0 / Math.PI) * r_w2t);
						a_w2t = a_w2t >= 0 ? a_w2t : 180 - a_w2t;
						// 목적구와 홀의 각도
						for (int h = 0; h < 6; h++) {
							double r_t2h = Math.atan2(holes[h][0] - balls[targetI[i]][0],
									holes[h][1] - balls[targetI[i]][1]);
							float a_t2h = (float) ((180.0 / Math.PI) * r_t2h);
							a_t2h = a_t2h >= 0 ? a_t2h : 180 - a_t2h;
							// 두 각의 차가 가장 적은 값 기록
							float a_gap = Math.min(Math.abs(a_w2t - a_t2h), 360 - Math.abs(a_w2t - a_t2h));
							if (a_gap < Math.abs(minA)) {
								minA = a_gap;
								minIdx = targetI[i];
								r_t2h_f = r_t2h;
							}
						}
					}
				} else { // 후공
					int[] targetI = { 2, 4, 5 };
					for (int i = 0; i < 3; i++) {
						if (balls[targetI[i]][0] == -1.0) { // 들어간 공 스킵
							alreadyin++;
							continue;
						}
						if (alreadyin < 2 && i == 2) {
							continue;
						}
						// 수구와 목적구의 각도
						double r_w2t = Math.atan2(balls[targetI[i]][0] - whiteBall_x,
								balls[targetI[i]][1] - whiteBall_y);
						float a_w2t = (float) ((180.0 / Math.PI) * r_w2t);
						a_w2t = a_w2t >= 0 ? a_w2t : 180 - a_w2t;
						// 목적구와 홀의 각도
						for (int h = 0; h < 6; h++) {
							double r_t2h = Math.atan2(holes[h][0] - balls[targetI[i]][0],
									holes[h][1] - balls[targetI[i]][1]);
							float a_t2h = (float) ((180.0 / Math.PI) * r_t2h);
							a_t2h = a_t2h >= 0 ? a_t2h : 180 - a_t2h;
							// 두 각의 차가 가장 적은 값 기록
							float a_gap = Math.min(Math.abs(a_w2t - a_t2h), 360 - Math.abs(a_w2t - a_t2h));
							if (a_gap < Math.abs(minA)) {
								minA = a_gap;
								minIdx = targetI[i];
								r_t2h_f = r_t2h;
							}
						}
					}
				}
				System.out.println(minA + "각으로선택됨");
				// - 공 선택 코드

				// 홀선택 문제있음 +추가코드로 홀 덮어써줌, 각도 덮어써줌
				int hnum = 0;
				double distM = 999;
				for (int i = 0; i < 6; i++) {
					float wtemp = holes[i][0] - balls[minIdx][0];
					float htemp = holes[i][1] - balls[minIdx][1];
					double distance = Math.sqrt(wtemp * wtemp + htemp * htemp);
					if (distance < distM) {
						hnum = i;
						distM = distance;
					}
				}
				r_t2h_f = Math.atan2(holes[hnum][0] - balls[minIdx][0], holes[hnum][1] - balls[minIdx][1]);
				// 덮어쓰기

				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				float targetBall_x = balls[minIdx][0];
				float targetBall_y = balls[minIdx][1];

				//
				float hitpoint_x = 0;
				float hitpoint_y = 0;
				float cosgap = (float) Math.cos(r_t2h_f) * 5.7f;
				float singap = (float) Math.sin(r_t2h_f) * 5.7f;
				System.out.println("gap=" + cosgap + " " + singap);
				hitpoint_x = targetBall_x - singap;
				hitpoint_y = targetBall_y - cosgap;
				System.out.println(r_t2h_f);
				System.out.println("hole\t" + holes[hnum][0] + " " + holes[hnum][1]);
				System.out.println("target\t" + targetBall_x + " " + targetBall_y);
				System.out.println("hitp\t " + hitpoint_x + " " + hitpoint_y);

				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float w_w2hp = hitpoint_x - whiteBall_x;
				float h_w2hp = hitpoint_y - whiteBall_y;
				double r_w2hp = Math.atan2(w_w2hp, h_w2hp);
				float a_w2hp = (float) ((180.0 / Math.PI) * r_w2hp);
				angle = (float) ((180.0 / Math.PI) * r_w2hp);
				angle = a_w2hp;
				// distance: 두 점(좌표) 사이의 거리를 계산
				double distance = Math.sqrt((w_w2hp * w_w2hp) + (h_w2hp * h_w2hp));

				// 임시 추가코드
				if (distance < 10)
					distance += 10;

				// power: 거리 distance에 따른 힘의 세기를 계산
				power = (float) distance;

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
				//
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
