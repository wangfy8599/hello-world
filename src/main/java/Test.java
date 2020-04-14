import com.google.common.base.Preconditions;

public class Test {
    public static double findInArray(int[] nums, int a, int left, boolean odd) {
        int m = (nums.length - 1)/2;
        if(a > nums[m] && nums.length % 2 == 0) {
            ++m;
        }
        int index = m - left;
        if(nums.length <= 2) {
            index = 0;
        }
        System.out.printf("%s,index=%d,a=%d,left=%d\n", odd ? "odd" : "even", index, a, left);
        if(a == nums[index]) {
            return a;
        } else if(a < nums[index]) {
            if(odd) {
                return nums[index];
            } else {
                if(index + 1 < nums.length) {
                    return (double)(nums[index] + nums[index + 1]) / 2;
                } else {
                    return (double)(a + nums[index]) / 2;
                }
            }
        } else {
            if(odd) {
                if(index + 1 < nums.length) {
                    return ((a < nums[index + 1]) ? a : nums[index + 1]);
                } else {
                    return a;
                }
            } else {
                if(index + 1 < nums.length) {
//                    if(a > nums[index + 1]) {
//                        return (double)(nums[index] + nums[index + 1]) / 2;
//                    } else {
                        return (double)(a + nums[index + 1]) / 2;
//                    }
                } else {
                    return (double)(a + nums[index]) / 2;
                }
            }
        }
    }
//
//    public static double findInLeft(int[] nums1, int[] nums2, int ai, int aj, int bi) {
//        int m = (nums1.length + nums2.length - 2)/2;
//        boolean odd = (nums1.length + nums2.length) % 2 == 1;
//        int index = m - bi;
//        System.out.printf("left,%s,index=%d,aj=%d,nums1[%d]=%d,nums2[%d]=%d\n", odd ? "odd" : "even", index, aj, index, nums1[index], bi, nums2[bi]);
//        if(nums2[bi] == nums1[index]) {
//            return nums2[bi];
//        } else if(nums2[bi] < nums1[index]) {
//            if(odd) {
//                return nums1[index];
//            } else {
//                if(index + 1 <= aj) {
//                    return (double)(nums1[index] + nums1[index + 1]) / 2;
//                } else {
//                    return (double)(nums2[bi] + nums1[index]) / 2;
//                }
//            }
//        } else {
//            if(odd) {
//                if(index + 1 <= aj) {
//                    return ((nums1[index + 1] < nums2[bi]) ? nums1[index + 1] : nums2[bi]);
//                } else {
//                    return nums1[index];
//                }
//            } else {
//                if(index + 1 <= aj) {
//                    return (double)(nums1[index + 1] + nums2[bi]) / 2;
//                } else {
//                    return (double)(nums1[index] + nums2[bi]) / 2;
//                }
//            }
//        }
//    }

    public static double findSimple(int[] nums) {
        boolean odd = nums.length % 2 == 1;
        int m = (nums.length - 1) / 2;
        if(odd) {
            return nums[m];
        }
        return (double)(nums[m] + nums[m+1])/2;
    }

    private static void printArray(String message, int[] nums) {
        System.out.print(message + "{");
        for(int i=0; i<nums.length; ++i) {
            if(i > 0) {
                System.out.print(",");
            }
            System.out.print(String.valueOf(nums[i]));
        }
        System.out.println("}");
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0) return findSimple(nums2);
        if(nums2.length == 0) return findSimple(nums1);

        printArray("Array A: ", nums1);
        printArray("Array B: ", nums2);

        int ai = 0, am = 0, aj = nums1.length - 1;
        int bi = 0, bm = 0, bj = nums2.length - 1;

        while(ai < aj && bi < bj) {
            am = (ai + aj)  / 2;
            bm = (bi + bj) / 2;
            if(nums1[am] < nums2[bm]) {
                if(ai == am) {
                    if(nums1[aj] > nums2[bm + 1]) {
                        aj = ai;
                        break;
                    } else if(nums1[aj] < nums2[bm+1]) {
                        bj = bm;
                        break;
                    }
//                    if(nums1[aj] < nums2[bm]) {
//                        ai = aj;
//                        bj = bm;
//                        break;
//                    }
//                    else if(nums1[aj] > nums2[bj]) {
//                        aj = am;
//                        break;
//                    } else if(nums1[aj] > nums2[bm]) {
//                        bj = bm;
//                        break;
//                    }
                } else if(bi == bm) {
                    if(nums1[aj] < nums2[bm] || nums1[am + 1] < nums2[bj]) {
                        ai = am;
                        bj = bm;
                        break;
                    }
                }
                ai = am;
                bj = bm + ((bi + bj) % 2);
            } else if(nums1[am] > nums2[bm]) {
                if(ai == am) {
                    if(nums1[aj] > nums2[bm]) {
                        aj = am;
                        break;
                    }
                } else if (bi == bm) {
//                    if(nums1[am] > nums2[bi]) {
//                        bi = bj;
//                        break;
//                    }
                    if(nums1[am] < nums2[bj]) {
                        bj = bi;
                        break;
                    }
                }
                aj = am + ((ai + aj) % 2);
                bi = bm;
            } else {
                return nums1[am];
            }
            System.out.printf("------({%d} - {%d}), ({%d} - {%d})", ai, aj, bi, bj);
            System.out.printf("------(%d - %d), (%d - %d)\n", nums1[ai], nums1[aj], nums2[bi], nums2[bj]);
        }

        System.out.printf("------({%d} - {%d}), ({%d} - {%d})", ai, aj, bi, bj);
        System.out.printf("------(%d - %d), (%d - %d)\n", nums1[ai], nums1[aj], nums2[bi], nums2[bj]);

        boolean odd = (nums1.length + nums2.length) %2 == 1;
        if(ai == aj) {
            return findInArray(nums2, nums1[ai], ai, odd);
        }
        return findInArray(nums1, nums2[bi], bi, odd);
    }

    public static void main(String[] args) throws Exception {
        double result = findMedianSortedArrays(new int[]{1},new int[]{2});
        Preconditions.checkState(result == 1.5f, String.format("%f != %f", result, 1.5f));
        result = findMedianSortedArrays(new int[]{1},new int[]{2,3});
        Preconditions.checkState(result == 2f, String.format("%f != %f", result, 2f));
        result = findMedianSortedArrays(new int[]{1,2},new int[]{3});
        Preconditions.checkState(result == 2f, String.format("%f != %f", result, 2f));
        result = findMedianSortedArrays(new int[]{1,3},new int[]{2});
        Preconditions.checkState(result == 2f, String.format("%f != %f", result, 2f));
        result = findMedianSortedArrays(new int[]{2,3},new int[]{1});
        Preconditions.checkState(result == 2f, String.format("%f != %f", result, 2f));
        result = findMedianSortedArrays(new int[]{2},new int[]{1,3});
        Preconditions.checkState(result == 2f, String.format("%f != %f", result, 2f));
        result = findMedianSortedArrays(new int[]{3},new int[]{1,2});
        Preconditions.checkState(result == 2f, String.format("%f != %f", result, 2f));
        result = findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
        Preconditions.checkState(result == 2.5f, String.format("%f != %f, {1,2}, {3,4}", result, 2.5f));
        result = findMedianSortedArrays(new int[]{1,3},new int[]{2,4});
        Preconditions.checkState(result == 2.5f, String.format("%f != %f", result, 2.5f));
        result = findMedianSortedArrays(new int[]{1,4},new int[]{2,3});
        Preconditions.checkState(result == 2.5f, String.format("%f != %f, {1,4}, {2,3}", result, 2.5f));

        result = findMedianSortedArrays(new int[]{1,3,5,7},new int[]{2,4,6,8});
        Preconditions.checkState(result == 4.5f, String.format("%f != %f, {1,3,5,7}, {2,4,6,8}", result, 4.5f));

        result = findMedianSortedArrays(new int[]{1,3,5,7,9},new int[]{2,4,6,8});
        Preconditions.checkState(result == 5f, String.format("%f != %f", result, 5f));

        result = findMedianSortedArrays(new int[]{1,3,5,7,9,11},new int[]{2,4,6,8});
        Preconditions.checkState(result == 5.5f, String.format("%f != %f, {1,3,5,7,9,11}, {2,4,6,8}", result, 5.5f));

        result = findMedianSortedArrays(new int[]{1,9},new int[]{2,4,6,8});
        Preconditions.checkState(result == 5f, String.format("%f != %f", result, 5f));

        result = findMedianSortedArrays(new int[]{},new int[]{1});
        Preconditions.checkState(result == 1f, String.format("%f != %f", result, 1f));

        result = findMedianSortedArrays(new int[]{},new int[]{2,4});
        Preconditions.checkState(result == 3f, String.format("%f != %f", result, 3f));

        result = findMedianSortedArrays(new int[]{3},new int[]{1});
        Preconditions.checkState(result == 2f, String.format("%f != %f", result, 2f));

        result = findMedianSortedArrays(new int[]{6,7},new int[]{1,2,3,4,5,8});
        Preconditions.checkState(result == 4.5f, String.format("%f != %f, {6,7}, {1,2,3,4,5,8}", result, 4.5f));

        result = findMedianSortedArrays(new int[]{1,2,3,4,5,8},new int[]{6,7});
        Preconditions.checkState(result == 4.5f, String.format("%f != %f, {1,2,3,4,5,8}, {6,7}", result, 4.5f));

        result = findMedianSortedArrays(new int[]{1,2},new int[]{3,4,5,6,7,8});
        Preconditions.checkState(result == 4.5f, String.format("%f != %f, {1,2}, {3,4,5,6,7,8}", result, 4.5f));

        result = findMedianSortedArrays(new int[]{1,2,3,4,5,6},new int[]{7,8});
        Preconditions.checkState(result == 4.5f, String.format("%f != %f, {1,2,3,4,5,6}, {7,8}", result, 4.5f));

    }
}
