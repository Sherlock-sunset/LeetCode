package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T71 {
    public String simplifyPath(String path) {
        List<String> paths = new ArrayList<>();
        String[] s = path.split("/");

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
            if (s[i].equals("..")) {
                if (!paths.isEmpty())
                    paths.remove(paths.size() - 1);
            } else if (s[i].equals(".")) {

            } else if (!s[i].isEmpty()) {
                paths.add(s[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            System.out.println(paths.get(i));
            sb.append("/" + paths.get(i));
        }
        return sb.toString().isEmpty() ? "/" : sb.toString();
    }
}
