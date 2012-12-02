/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AMatchedIfexpr extends PIfexpr
{
    private PMatchedstmt _matchedstmt_;

    public AMatchedIfexpr()
    {
        // Constructor
    }

    public AMatchedIfexpr(
        @SuppressWarnings("hiding") PMatchedstmt _matchedstmt_)
    {
        // Constructor
        setMatchedstmt(_matchedstmt_);

    }

    @Override
    public Object clone()
    {
        return new AMatchedIfexpr(
            cloneNode(this._matchedstmt_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMatchedIfexpr(this);
    }

    public PMatchedstmt getMatchedstmt()
    {
        return this._matchedstmt_;
    }

    public void setMatchedstmt(PMatchedstmt node)
    {
        if(this._matchedstmt_ != null)
        {
            this._matchedstmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._matchedstmt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._matchedstmt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._matchedstmt_ == child)
        {
            this._matchedstmt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._matchedstmt_ == oldChild)
        {
            setMatchedstmt((PMatchedstmt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
