package com.example.coronavirus.restclient.dto.corona;


public class Corona {

    private Header header;

    private Body body;

    public Header getHeader ()
    {
        return header;
    }

    public void setHeader (Header header)
    {
        this.header = header;
    }

    public Body getBody ()
    {
        return body;
    }

    public void setBody (Body body)
    {
        this.body = body;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [header = "+header+", body = "+body+"]";
    }

}
