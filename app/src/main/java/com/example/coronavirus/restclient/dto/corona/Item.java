package com.example.coronavirus.restclient.dto.corona;

public class Item
{
    private String accDefRate;

    private String clearCnt;

    private String stateDt;

    private String updateDt;

    private String createDt;

    private String examCnt;

    private String accExamCnt;

    private String stateTime;

    private String deathCnt;

    private String decideCnt;

    private String resutlNegCnt;

    private String accExamCompCnt;

    private String careCnt;

    private String seq;



    public String getAccDefRate ()
    {
        return accDefRate;
    }

    public void setAccDefRate (String accDefRate)
    {
        this.accDefRate = accDefRate;
    }

    public String getClearCnt ()
    {
        return clearCnt;
    }

    public void setClearCnt (String clearCnt)
    {
        this.clearCnt = clearCnt;
    }

    public String getStateDt ()
    {
        return stateDt;
    }

    public void setStateDt (String stateDt)
    {
        this.stateDt = stateDt;
    }

    public String getCreateDt ()
    {
        return createDt;
    }

    public void setCreateDt (String createDt)
    {
        this.createDt = createDt;
    }

    public String getExamCnt ()
    {
        return examCnt;
    }

    public void setExamCnt (String examCnt)
    {
        this.examCnt = examCnt;
    }

    public String getAccExamCnt ()
    {
        return accExamCnt;
    }

    public void setAccExamCnt (String accExamCnt)
    {
        this.accExamCnt = accExamCnt;
    }

    public String getStateTime ()
    {
        return stateTime;
    }

    public void setStateTime (String stateTime)
    {
        this.stateTime = stateTime;
    }

    public String getDeathCnt ()
    {
        return deathCnt;
    }

    public void setDeathCnt (String deathCnt)
    {
        this.deathCnt = deathCnt;
    }

    public String getDecideCnt ()
    {
        return decideCnt;
    }

    public void setDecideCnt (String decideCnt)
    {
        this.decideCnt = decideCnt;
    }

    public String getResutlNegCnt ()
    {
        return resutlNegCnt;
    }

    public void setResutlNegCnt (String resutlNegCnt)
    {
        this.resutlNegCnt = resutlNegCnt;
    }

    public String getAccExamCompCnt ()
    {
        return accExamCompCnt;
    }

    public void setAccExamCompCnt (String accExamCompCnt)
    {
        this.accExamCompCnt = accExamCompCnt;
    }

    public String getCareCnt ()
    {
        return careCnt;
    }

    public void setCareCnt (String careCnt)
    {
        this.careCnt = careCnt;
    }

    public String getSeq ()
    {
        return seq;
    }

    public void setSeq (String seq)
    {
        this.seq = seq;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [accDefRate = "+accDefRate+", clearCnt = "+clearCnt+", stateDt = "+stateDt+", updateDt = "+updateDt+", createDt = "+createDt+", examCnt = "+examCnt+", accExamCnt = "+accExamCnt+", stateTime = "+stateTime+", deathCnt = "+deathCnt+", decideCnt = "+decideCnt+", resutlNegCnt = "+resutlNegCnt+", accExamCompCnt = "+accExamCompCnt+", careCnt = "+careCnt+", seq = "+seq+"]";
    }
}