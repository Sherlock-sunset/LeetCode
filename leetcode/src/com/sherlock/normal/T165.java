package com.sherlock.normal;

public class T165 {
    public int compareVersion(String version1, String version2) {
        String[] versionChar1 = version1.replace('.', 'a').split("a");
        String[] versionChar2 = version2.replace('.', 'a').split("a");
        for (int i = 0; i < Math.max(versionChar1.length, versionChar2.length); i++) {
            if ((i < Math.min(versionChar1.length, versionChar2.length)) || (i == Math.min(versionChar1.length, versionChar2.length) && versionChar1.length == versionChar2.length)) {
                int v1 = Integer.parseInt(versionChar1[i]);
                int v2 = Integer.parseInt(versionChar2[i]);

                if (v1 > v2) return 1;
                if (v1 < v2) return -1;
            } else {
                int v = Integer.parseInt(versionChar1.length > versionChar2.length ? versionChar1[i] : versionChar2[i]);
                if (v > 0) return versionChar1.length > versionChar2.length ? 1 : -1;
            }

        }
        return 0;
    }
}
