package com.example.kimsungwon.example01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.dataludi.charting.ChartComponent;
import com.dataludi.common.Utils;
import com.dataludi.grids.GridComponent;
import com.dataludi.grids.GridView;
import com.dataludi.ui.UIComponent;

public class MainActivity extends AppCompatActivity {

    GridView m_grid;
    IGridDemo.IAction[] m_gridActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ViewGroup layout = (ViewGroup)findViewById(R.id.mainLayout);

        UIComponent view = setupGrid();
//        UIComponent view = setupChart();

        layout.addView(view);

        // action bar
        //getSupportActionBar().hide();
//        getSupportActionBar().setTitle("XXXXX");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (m_gridActions != null) {
            for (int i = 0; i < m_gridActions.length; i++) {
                IGridDemo.IAction action = m_gridActions[i];
                menu.add(0, i, i, action.getLabel());
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (m_gridActions != null) {
            IGridDemo.IAction action = m_gridActions[item.getItemId()];
            try {
                action.run(m_grid);
            } catch (Throwable ex) {
                ex.printStackTrace();
                Utils.alert(this, ex.getMessage());
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private UIComponent setupGrid() {
        GridComponent container = new GridComponent(this);

        IGridDemo demo = new HelloGridDemo();

        m_grid = (GridView)container.getGridView();
        m_gridActions = demo.getActions();

        try {
            //getSupportActionBar().setTitle(demo.getClass().getSimpleName());
            getSupportActionBar().setTitle(demo.getLabel());
            demo.setupGrid(this, m_grid);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return container;
    }

    private UIComponent setupChart() {
        ChartComponent container = new ChartComponent(this);

//        IChartDemo demo = new HelloChartExam();
//        IChartDemo demo = new ColumnChartExam();
//        IChartDemo demo = new PieChartExam();

        try {
            //getSupportActionBar().setTitle(demo.getLabel());
//            getSupportActionBar().setTitle(demo.getClass().getSimpleName());
//            demo.setupChart(this, container.getChartView());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return container;
    }
}
