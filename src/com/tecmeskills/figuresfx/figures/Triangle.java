package com.tecmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Objects;

public class Triangle extends Figure {
    private double ribLEngth;

    private Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double ribLEngth) {
        this(cx, cy, lineWidth, color);
        this.ribLEngth = ribLEngth < 10 ? 10 : ribLEngth;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{cx, cx + ribLEngth / 2, cx + ribLEngth / 2},
                new double[]{cy, cy + ribLEngth / 2, cy - ribLEngth / 2}, 3);
    }

    public double getRibLEngth() {
        return ribLEngth;
    }

    public void setRibLEngth(double ribLEngth) {
        this.ribLEngth = ribLEngth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.ribLEngth, ribLEngth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ribLEngth);
    }
}