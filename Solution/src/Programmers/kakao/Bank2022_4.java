package Programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Bank2022_4 {
	class Node {
		String name;
		List<Node> children;
		HashMap<String, Node> childrenMap;
		public Node(String name) {
			this.name = name;
			this.children = new ArrayList<>();
			this.childrenMap = new HashMap<>();
		}

		public Node getChild(String name) {
			return this.childrenMap.get(name);
		}
		public void addChild(Node child) {
			children.add(child);
			childrenMap.put(child.name, child);
		}

		public void makeDir(String dir) {
			if(dir.length() == 0) {
				return;
			}

			String nodeName = getNodeName(dir);
			String subPath = getSubPath(dir);

			if(childrenMap.containsKey(nodeName)) {
				childrenMap.get(nodeName).makeDir(subPath);
				return;
			}

			Node child = new Node(nodeName);
			addChild(child);
			child.makeDir(subPath);
		}

		public String getNodeName(String dir) {
			int idx = dir.indexOf("/");

			if(idx == -1) {
				return dir;
			}

			return dir.substring(0, idx);
		}

		public String getSubPath(String dir) {
			int idx = dir.indexOf("/");

			if(idx == -1) {
				return "";
			}

			return dir.substring(idx).substring(1);
		}

		public Node findNode(String dir) {
			Node node = this;
			String nodeName = getNodeName(dir);

			while(nodeName.length() > 0) {
				node = node.getChild(nodeName);
				dir = getSubPath(dir);
				nodeName = getNodeName(dir);
			}

			return node;
		}

		public void removeDir(String dir) {
			int index = dir.lastIndexOf("/");
			String nodeName = dir.substring(index+1);
			Node node;
			if(index > 0) {
				node = findNode(dir.substring(1, index));
			}else{
				node = this;
			}

			node.removeChild(nodeName);
		}

		void removeChild(String name) {
			Node child = this.getChild(name);

			this.children.remove(child);
			this.childrenMap.remove(name);
		}
		void getDirectories(List<String> dirs, String preDir) {
			String fullDir;

			if(name.equals("")) {
				fullDir = "";
				dirs.add("/");
			}else {
				fullDir = preDir + "/" + this.name;
				dirs.add(fullDir);
			}

			Collections.sort(children, Comparator.comparing(o -> o.name));

			for(Node child : children) {
				child.getDirectories(dirs, fullDir);
			}
		}
	}

	public String[] solution(String[] directory, String[] command) {
		Node root = new Node("");

		for (String dir : directory) {
			root.makeDir(dir.substring(1));
		}

		for (int i = 0; i < command.length; i++) {
			String[] cmd = command[i].split(" ");

			if(cmd[0].equals("mkdir")) {
				root.makeDir(cmd[1].substring(1));
				continue;
			}

			if(cmd[0].equals("rm")) {
				root.removeDir(cmd[1]);
				continue;
			}

			if(cmd[0].equals("cp")) {
				Node copyNode = root.findNode(cmd[2].substring(1));
				Node dir = root.findNode(cmd[1].substring(1));

				copyNode.addChild(dir);
			}
		}

		List<String> answer = new ArrayList<>();
		root.getDirectories(answer,"");

		return answer.toArray(new String[answer.size()]);

	}

	public static void main(String[] args) {
		String[] directory = {"/",
			"/hello",
			"/hello/tmp",
			"/root",
			"/root/abcd",
			"/root/abcd/etc",
			"/root/abcd/hello"};
		String[] command = {"mkdir /root/tmp",
			"cp /hello /root/tmp",
			"rm /hello"};
		Bank2022_4 a = new Bank2022_4();
		String[] answer = a.solution(directory, command);

		System.out.println(Arrays.toString(answer));
	}
}
