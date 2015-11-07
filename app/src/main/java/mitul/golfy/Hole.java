package mitul.golfy;

/**
 * Created by mitul on 07/11/15.
 */
public class Hole {
    private String mLabel;
    private int mStokeCount;

    public Hole(String Label,int StokeCount){
        this.mLabel = Label;
        this.mStokeCount = StokeCount;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public int getStokeCount() {
        return mStokeCount;
    }

    public void setStokeCount(int stokeCount) {
        mStokeCount = stokeCount;
    }
    public int increment_score(){
        mStokeCount += 1;
        return mStokeCount;
    }
    public int decrement_score(){
        if (getStokeCount() > 0)
        mStokeCount -= 1;
        return mStokeCount;
    }
}
