package com.sherlock.dynamic_programming;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 *  
 */
public class T978 {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.maxTurbulenceSize(9, 4, 2, 10, 7, 8, 8, 1, 9));
        System.out.println(so.maxTurbulenceSize(4, 8, 12, 16));
        System.out.println(so.maxTurbulenceSize(100));
        System.out.println(so.maxTurbulenceSize(20139, 81378, 2481, 28634, 85929, 85544, 11925, 81989, 7988, 37255, 40179, 47403, 94119, 6931, 3304, 75116, 50953, 93923, 81930, 41072, 46267, 68680, 30665, 87113, 62556, 7249, 18549, 1108, 35840, 62910, 44416, 22825, 76705, 48168, 41182, 33930, 59080, 34150, 33752, 27250, 74819, 72764, 55778, 56126, 4923, 67219, 41218, 51928, 10800, 94338, 91010, 95816, 45597, 66196, 71747, 52922, 80013, 10182, 92174, 85162, 14454, 18610, 39339, 306, 8871, 10989, 88613, 53278, 72922, 36100, 87781, 69307, 13328, 98190, 42436, 13520, 64108, 64795, 4818, 91292, 13155, 3426, 96600, 85766, 41274, 79233, 82614, 62669, 97029, 81057, 48849, 97685, 49839, 10409, 29065, 20971, 30892, 61282, 98880, 67105, 28467, 80970, 66076, 18107, 3276, 79580, 14735, 36963, 91245, 85521, 45441, 95433, 20430, 13999, 46839, 78945, 32718, 33941, 48678, 15896, 22562, 95700, 26561, 25933, 34842, 98885, 67743, 11996, 66772, 5194, 38699, 45603, 45191, 98644, 92604, 33101, 20905, 75126, 85263, 24435, 61183, 54394, 80186, 29349, 29650, 57012, 90807, 88477, 27804, 79343, 40709, 42410, 62688, 69311, 39682, 40963, 6186, 90101, 34797, 5410, 716, 77274, 98522, 9160, 38232, 58672, 56217, 34966, 30595, 79824, 809, 6595, 26654, 42070, 35002, 7579, 62773, 70071, 8772, 41796, 8819, 14086, 56487, 41363, 69728, 31593, 80875, 56537, 17372, 58755, 19375, 12407, 79353, 535, 60473, 77764, 98245, 97424, 79759, 7828, 13750, 25941, 32374, 54229, 53714, 91022, 45100, 19214, 92129, 63116, 81637, 95268, 41570, 17715, 64053, 79299, 12488, 57232, 80971, 28074, 16441, 32193, 8294, 30185, 51114, 92038, 93200, 93357, 11902, 4217, 29573, 16439, 15088, 13456, 91914, 69965, 73598, 97441, 65685, 47628, 82870, 98093, 12624, 74031, 86151, 88050, 27629, 18618, 90372, 16509, 73908, 45923, 24820, 92050, 86334, 51169, 96130, 68862, 90565, 99035, 31139, 43080, 19527, 22126, 52570, 67275, 41297, 6841, 64025, 84302, 67465, 43908, 72003, 33119, 37463, 32594, 53008, 61277, 12135, 58373, 14786, 38086, 2409, 94779, 77012, 36251, 53924, 64455, 89145, 39912, 44422, 61621, 95925, 11694, 22307, 67557, 28283, 90177, 57970, 92925, 39727, 85606, 74021, 35409, 13675, 55752, 59754, 26485, 65186, 63562, 95981, 43829, 60831, 75901, 30843, 76193, 12673, 62257, 75911, 51253, 73307, 85258, 10560, 82780, 60264, 36420, 77372, 86750, 79009, 40498, 97559, 49100, 59836, 45574, 70547, 80846, 25848, 68446, 7010, 51820, 59259, 11797, 57183, 48446, 75342, 15858, 89528, 24695, 41419, 93599, 91731, 24959, 31037, 39878, 40782, 54487, 47934, 60543, 98867, 20184, 51586, 80185, 38564, 68384, 32141, 79869, 49773, 29870, 86621, 77913, 52300, 22461, 32280, 64883, 58425, 93513, 34571, 47020, 62967, 62712, 69321, 57617, 79972, 25874, 76169, 4861, 40785, 97328, 48078, 26060, 89027, 84068, 54302, 6611, 95452, 73801, 64327, 82294, 17874, 29691, 56774, 13041, 51381, 60067, 28985, 68765, 62969, 84317, 11595, 96079, 26155, 52199, 60927, 34067, 52257, 99249, 23139, 21073, 67338, 28650, 17358, 29576, 21963, 36531, 67171, 16919, 91135, 49328, 56508, 58782, 67571, 33131, 770, 82401, 70343, 69458, 1919, 28242, 55176, 30551, 31062, 6550, 27307, 97978, 69092, 46089, 75003, 65981, 26942, 17891, 88438, 4246, 18844, 90363, 2977, 66344, 43914, 4381, 67111, 3164, 98882, 91404, 32457, 97178, 65449, 32245, 81454, 52740, 39882, 22707, 64533, 339, 17746, 13391, 83531, 34339, 18509, 35441, 13839, 8171, 17351, 23950, 99939, 38085, 2109, 35990, 95542, 36995, 60809, 49967, 82694, 49709, 94552, 82415, 46432, 99104, 52606, 12130, 69340, 57495, 65080, 24299, 74950, 78718, 5435, 79494, 31201, 71679, 86026, 67747, 72258, 37981, 9688, 85010, 1502, 94475, 93644, 11139, 69555, 51447, 34953, 26662, 25419, 65371, 12880, 19043, 3964, 8336, 35820, 46590, 21988, 23248, 5364, 82818, 73406, 695, 55645, 56518, 59658, 34621, 63758, 85722, 20188, 4198, 49056, 73439, 12949, 289, 31196, 25091, 69448, 58028, 80680, 56125, 15674, 67118, 61294, 3862, 73116, 31820, 59603, 16544, 9089, 81244, 88506, 72150, 59579, 14687, 93785, 75583, 20946, 71087, 11674, 98081, 39599, 93460, 70077, 38979, 32410, 61753, 48637, 6954, 69955, 82836, 63285, 29290, 95643, 92897, 82369, 24412, 36913, 13115, 21376, 20964, 57305, 79406, 57722, 93586, 4504, 90900, 27551, 75142, 63237, 14041, 77415, 65666, 67419, 37078, 76698, 15348, 43514, 32368, 99733, 44548, 60610, 6389, 36541, 62252, 98414, 69623, 95400, 54341, 50210, 40190, 89464, 22708, 7095, 84440, 922, 97577, 82271, 15107, 50741, 46367, 73469, 68993, 6175, 43446, 70868, 28613, 22836, 33476, 30297, 87449, 85760, 9882, 7406, 63073, 28830, 4738, 91077, 55475, 77649, 4174, 42388, 52023, 79618, 50322, 17230, 20529, 17767, 66081, 53297, 18552, 86257, 33838, 18280, 49613, 67985, 81479, 448, 52160, 79004, 63067, 9618, 75765, 44260, 66192, 36524, 17567, 10397, 81169, 68445, 62018, 99910, 73379, 77054, 49780, 51559, 14687, 57187, 63379, 13994, 71408, 16989, 11855, 67869, 64592, 27893, 64456, 65298, 39117, 39198, 93968, 48419, 52532, 80370, 95860, 71813, 60456, 85372, 303, 3612, 18575, 47183, 44976, 62503, 9746, 63893, 83975, 23025, 89258, 92656, 46055, 16351, 88855, 98410, 15191, 34798, 38190, 90573, 58033, 54836, 28727, 9271, 63777, 84166, 95664, 58837, 91986, 93282, 30759, 62791, 96579, 28709, 47520, 11115, 86163, 76649, 50336, 46519, 79361, 17889, 64283, 64258, 15953, 43339, 4516, 16714, 24556, 59334, 49766, 28566, 86857, 63180, 74243, 24025, 5610, 46536, 24659, 44253, 62337, 6102, 28004, 90987, 66166, 98254, 96571, 35091, 78858, 75288, 72752, 72174, 41054, 93939, 67181, 51546, 42975, 50003, 43166, 71553, 88350, 41698, 91823, 19743, 66010, 92326, 48883, 94325, 32340, 71674, 66734, 99908, 68658, 85600, 2364, 8935, 51434, 73008, 51013, 91720, 68502, 38855, 30741, 3599, 98269, 55479, 61111, 21924, 86615, 38257, 60324, 12332, 5496, 59115, 98235, 75811, 80167, 59842, 55219, 61783, 78213, 68607, 45196, 99910, 12115, 74026, 65133, 85669, 58830, 7874, 52273, 905, 17113, 92318, 48665, 23757, 88982, 59104, 58854, 24440, 45818, 24233, 92150, 5163, 74797, 54739, 78398, 10427, 8588, 99036, 84902, 21853, 62113, 66871, 3056, 66940, 47871, 29681, 7525, 90227, 69785, 84291, 78045, 62721, 6455, 87153, 22132, 61421, 32966, 27617, 367, 76783, 4064, 40051, 38900, 23586, 9940, 33628, 94744, 1018, 74325, 20074, 38922, 85815, 21241, 78584, 90979, 43693, 31594, 16227, 87154, 37796, 52087, 90036, 88169, 33623, 6744, 58251, 7075, 71285, 81930, 98005, 99071, 28785, 57210, 4003, 47285, 72816, 21207, 83522, 11522, 97080, 95298, 73063, 17077, 53433, 39906, 75360, 80261, 32911, 34362, 91937, 76128, 5575, 76188, 79358, 20550, 49751, 80698, 65202, 71366, 57213, 24463, 35084, 78217, 68818, 74858, 89972, 72356, 47569, 46271, 67991, 94929, 55258, 66948, 65980, 76357, 88020, 6724, 91021, 85711, 39035, 23591, 1905, 99605, 86916, 50648, 58231, 12914, 74923, 41625, 25127, 75880, 73858, 25555, 21205, 96715, 35761, 20753, 86494, 19774, 23901, 86096, 74887, 43040, 45424, 29167, 97408, 14963, 51128, 73815, 90506, 11081, 32912, 78214, 56075, 42651, 77394, 76566));

    }

    public static class Solution {
        //动态规划
        public int maxTurbulenceSize(int... A) {
            int max = 1;
            if (A.length <= 2) {
                max = A.length == 2 && A[0] != A[1] ? 2 : 1;
                return max;
            }
            max = A[0] != A[1] ? 2 : 1;

//            int[] dp = new int[A.length];//其实最后发现不需要这些额外存储，记录上一个长度就行
//            dp[0] = 1;
//            dp[1] = 2;
//            for (int i = 2; i < A.length; i++) {
//                if (A[i] == A[i - 1])
//                    dp[i] = 1;
//                else if (((A[i - 1] > A[i]) && A[i - 2] <= A[i - 1]) || ((A[i - 1] < A[i]) && A[i - 2] >= A[i - 1]))
//                    dp[i] = dp[i - 1] + 1;
//                else
//                    dp[i] = 2;
//                max = Math.max(dp[i], max);
            int current = max;
            for (int i = 2; i < A.length; i++) {
                if (A[i] == A[i - 1])
                    current = 1;
                else if (((A[i - 1] > A[i]) && A[i - 2] <= A[i - 1]) || ((A[i - 1] < A[i]) && A[i - 2] >= A[i - 1]))
                    current++;
                else
                    current = 2;
                max = Math.max(current, max);

                // 优化，max过半 得出答案,只适合数组长度非常长的时候
//                if (dp[i] < max && (A.length - i - 1 + dp[i]) <= max)
//                    return max;
            }
            return max;
        }
    }
}
