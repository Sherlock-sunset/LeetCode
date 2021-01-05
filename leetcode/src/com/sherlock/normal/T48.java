package com.sherlock.normal;

//你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//空间复杂度要求伟O(1)
public class T48 {
    public void rotate(int[][] matrix) {
        int cNum = matrix[0].length;//几列
        int rNum = matrix.length;//几行
        //转换关系是(r,c)->(c,rNum-r)
        for (int r = 0; r < rNum; r++) {
            for (int c = r; c < cNum-r; c++) {
                rotate(matrix,r,c,matrix[r][c],rNum,0);
            }
        }
    }

    public void rotate(int[][] matrix, int or, int oc, int oNum, int rNum, int currentRotateTime) {
        int r = oc, c = rNum - or;
        int targetNum = matrix[r][c];
        matrix[r][c] = oNum;
        if (currentRotateTime < 3 && c != oc)
            rotate(matrix, r, c, targetNum, rNum,currentRotateTime+1);
    }
}
