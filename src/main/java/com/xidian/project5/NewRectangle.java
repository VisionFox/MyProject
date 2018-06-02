package com.xidian.project5;

//3-3-(2)-(5)
public class NewRectangle {
    double width;
    double height;
    Point p = new Point();//若不初始化，后面p的成员变量时会出现空指针异常

    public NewRectangle() {
        this.width = 0.0;
        this.height = 0.0;
        this.p.x = 0.0;
        this.p.y = 0.0;
    }

    public NewRectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.p.x = 0.0;
        this.p.y = 0.0;
    }

    public NewRectangle(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
        this.p.x = x;
        this.p.y = y;
    }

    public boolean bPointIn(Point p) {
        boolean flag = false;

        if (((p.x >= this.p.x) && (p.x <= (this.p.x + this.width))) && ((p.y >= this.p.y) && (p.y <= (this.p.y + this.height)))) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;
    }
    //3-(5)
    public boolean overlap(NewRectangle nr) {
        boolean flag = false;
        //找出两个长方形的中点坐标
        Point thisCenterPoint = new Point((double) (this.p.x + this.width) / 2, (double) (this.p.y + this.height) / 2);
        Point nrCenterPoint = new Point((double) (nr.p.x + nr.width) / 2, (double) (nr.p.y + nr.height) / 2);
        //计算出两个中点坐标的x和y的相互距离
        double centXtoX = Math.abs(thisCenterPoint.x - nrCenterPoint.x);
        double centYtoY = Math.abs(thisCenterPoint.y - nrCenterPoint.y);
        if ((centXtoX < (this.width + nr.width) / 2) && (centYtoY < (this.height + nr.height) / 2)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }
}
