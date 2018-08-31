package com.example.kimsungwon.example01;

import com.dataludi.grids.GridColumn;

public interface ColumnCallback<T extends GridColumn> {

    void onCreate(T column);
}
