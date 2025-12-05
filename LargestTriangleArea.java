class Solution {
    /*
    Shoelace Formula
    Solves area for any simple polygon
        Any number of vertices
    Vertices must be order (clockwise/counter-clockwise)

    Forward Diagonal Products
    a[0] * b[1] + b[0] * c[1] + ... + z[0] * a[1]
    Backward Diagonal Products
    a[1] * b[0] + b[1] * c[0] + ... + z[1] * a[0]
    Area = 0.5(|Foward-Backward|)
    */
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int[] x = points[i];
                    int[] y = points[j];
                    int[] z = points[k];

                    double forwardDiag = x[0] * y[1] + y[0] * z[1] + z[0] * x[1];
                    double backwardDiag = x[1] * y[0] + y[1] * z[0] + z[1] * x[0];

                    double cur = (Math.abs(forwardDiag - backwardDiag))/2;
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
}
