package com.example.kimsungwon.example01;

import android.content.Context;

import com.dataludi.grids.GridView;

/**
 * Grid demo spec.
 */
public interface IGridDemo {

    interface IAction {
        String getLabel();
        void run(GridView grid) throws Exception;
    }

    String getLabel();
    void setupGrid(final Context context, final GridView grid) throws Exception;
    IAction[] getActions();
}
