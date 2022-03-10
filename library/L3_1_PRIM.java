package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class L3_1_PRIM {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		int[][] adjMatrix = new int[N][N];
		int[] minEdge = new int[N]; // 내가 갈 수 있는 정점들 중 가장 가까운 정점과의 거리를 저장하는 배열
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			minEdge[i] = Integer.MAX_VALUE; // 무한대로 초기화
		}

		int result = 0; // MST 비용
		minEdge[0] = 0; // 임의 점, 0번 선택

		for (int c = 0; c < N; c++) { // N개 정점 모두 연결
			// 신장트리에 연결되지 않은 정점들 중 가장 유리한 비용의 정점 선택
			int min = Integer.MAX_VALUE;
			int minVertex = 0;

			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			// 선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			result += min;

			// 선택된 정점 기준으로 비트리 정점들로의 간선비용 따져보고 최소값 갱신
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(result);

	}
}
