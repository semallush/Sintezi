package com.io.sintezi;

//maj 130.81, 146.83, 164.81, 174.61, 196.00, 220.00, 246.94
//min 130.81, 146.83, 155.56, 174.61, 196.00, 207.65, 233.08
//blues 130.81, 155.56, 174.61, 185.00, 196.00, 233.08, 261.63
enum ScaleType {
 MAJOR,
 MINOR,
 BLUES
}

public class Scale {

    private  float[] values = new float[7];
    private  ScaleType scaleType = ScaleType.MAJOR;

    public void setScaleType(ScaleType type) {
        this.scaleType = type;
        setValues(this.scaleType);
    }
    private void setValues(ScaleType type) {
        switch (type) {
            case MAJOR:
                this.values[0] = (float) 130.81;
                this.values[1] = (float) 146.83;
                this.values[2] = (float) 164.81;
                this.values[3] = (float) 174.61;
                this.values[4] = (float) 196.00;
                this.values[5] = (float) 220.00;
                this.values[6] = (float) 246.94;
                break;

            case MINOR:
                this.values[0] = (float) 130.81;
                this.values[1] = (float) 146.83;
                this.values[2] = (float) 155.56;
                this.values[3] = (float) 174.61;
                this.values[4] = (float) 196.00;
                this.values[5] = (float) 207.65;
                this.values[6] = (float) 233.08;
                break;
            case BLUES:
                this.values[0] = (float) 130.81;
                this.values[1] = (float) 155.56;
                this.values[2] = (float) 174.61;
                this.values[3] = (float) 185.00;
                this.values[4] = (float) 196.00;
                this.values[5] = (float) 233.08;
                this.values[6] = (float) 261.63;
                break;
        }
    }
    public float[] getValues() {
        return this.values;
    }

}
