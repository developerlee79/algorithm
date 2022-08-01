package string;

import Algorithm.structure.set.Set;
import Algorithm.structure.set.hashset.HashSet;

public class leetcode_929 {
    public static void main(String[] args) {
        leetcode_929 lc = new leetcode_929();
        String[] emailArr = {"fg.r.u.uzj+o.pw@kziczvh.com", "r.cyo.g+d.h+b.ja@tgsg.z.com",
                "fg.r.u.uzj+o.f.d@kziczvh.com", "r.cyo.g+ng.r.iq@tgsg.z.com", "fg.r.u.uzj+lp.k@kziczvh.com",
                "r.cyo.g+n.h.e+n.g@tgsg.z.com", "fg.r.u.uzj+k+p.j@kziczvh.com", "fg.r.u.uzj+w.y+b@kziczvh.com",
                "r.cyo.g+x+d.c+f.t@tgsg.z.com", "r.cyo.g+x+t.y.l.i@tgsg.z.com", "r.cyo.g+brxxi@tgsg.z.com", "r.cyo.g+z+dr.k.u@tgsg.z.com",
                "r.cyo.g+d+l.c.n+g@tgsg.z.com", "fg.r.u.uzj+vq.o@kziczvh.com", "fg.r.u.uzj+uzq@kziczvh.com", "fg.r.u.uzj+mvz@kziczvh.com",
                "fg.r.u.uzj+taj@kziczvh.com", "fg.r.u.uzj+fek@kziczvh.com"};
        System.out.println(lc.numUniqueEmails(emailArr));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> resultSet = new HashSet<>();

        for (String email : emails) {
            if (!email.contains("@") || email.split("@").length > 2) continue;

            String tmp = email.split("@")[0];
            String tmp2 = email.split("@")[1];
            if (tmp2.contains("\\+")) continue;

            if (tmp.contains(".")) tmp = tmp.replace(".", "");
            if (tmp.contains("+")) {
                if (tmp.charAt(0) == '+') continue;
                tmp = tmp.split("\\+")[0];
            }

            resultSet.add(tmp + "@" + tmp2);
        }

        return resultSet.size();
    }
}
