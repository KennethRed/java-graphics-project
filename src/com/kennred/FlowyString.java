package com.kennred;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class FlowyString {

    int OriginX;
    int OriginY;
    int particleCount;
    int particleStartSize;
    double particleDecrease;
    double particleOffsetX;
    boolean isParticleOffsetXIncrementing;

    public double getParticleOffsetX() {
        return particleOffsetX;
    }

    public void setParticleOffsetX(double particleOffsetX) {
        this.particleOffsetX = particleOffsetX;
    }

    public boolean isParticleOffsetXIncrementing() {
        return isParticleOffsetXIncrementing;
    }

    public void setParticleOffsetXIncrementing(boolean particleOffsetXIncrementing) {
        isParticleOffsetXIncrementing = particleOffsetXIncrementing;
    }

    public int getOriginX() {
        return OriginX;
    }

    public void setOriginX(int originX) {
        OriginX = originX;
    }

    public int getOriginY() {
        return OriginY;
    }

    public void setOriginY(int originY) {
        OriginY = originY;
    }

    public int getParticleCount() {
        return particleCount;
    }

    public void setParticleCount(int particleCount) {
        this.particleCount = particleCount;
    }

    public int getParticleStartSize() {
        return particleStartSize;
    }

    public void setParticleStartSize(int particleStartSize) {
        this.particleStartSize = particleStartSize;
    }

    public double getParticleDecrease() {
        return particleDecrease;
    }

    public void setParticleDecrease(double particleDecrease) {
        this.particleDecrease = particleDecrease;
    }

    public void draw(Graphics2D g2D) {

        AffineTransform old = g2D.getTransform();


        g2D.setColor(new Color(
                0.1f,
                0.1f,
                0.1f,
                (float) mapRange(50, 0, 1, 0.3, this.particleCount)
        ));

        for (int i = 0; i < this.getParticleCount(); i++) {

            int particleXPos = (int) (
                    (this.getParticleStartSize() / 10) * (Math.pow(i, this.getParticleOffsetX()))
            );

            if (this.getParticleStartSize() - (this.getParticleDecrease() * i) < 0) {
                break;
            }

            g2D.fillRect(
                    this.getOriginX() + particleXPos,
                    (int) (this.getOriginY() - ((this.getParticleStartSize() * i) + (this.getParticleDecrease() * i))),
                    (int) (this.getParticleStartSize() - (this.getParticleDecrease() * i)),
                    (int) (this.getParticleStartSize() - (this.getParticleDecrease() * i))
            );

        }
        g2D.setTransform(old);


    }

    public static double mapRange(double a1, double a2, double b1, double b2, double s) {
        return b1 + ((s - a1) * (b2 - b1)) / (a2 - a1);
    }


}
