package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 27/06/2025 18:22
 * @Version : V1.0
 * @Description :
 */
public class SimplifyPath71 {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> s = new Stack<>();

        for (String a : arr) {
            if (a.equals("") || a.equals(".")) {
                continue;
            } else if (a.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(a);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : s) {
            sb.append("/").append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}
