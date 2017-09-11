package com.vaadin.demo.dashboard.component.chart;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.ui.Component;


@SuppressWarnings("serial")
public class DefectPriorityChart extends Chart {


    public DefectPriorityChart(){


        getConfiguration().getChart().setType(ChartType.AREASPLINE);

        getConfiguration().getChart().setSpacingBottom(30);

        getConfiguration().setTitle("Количество блокирующих и критических дефектов");


        XAxis x = new XAxis();
        x.setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec");
        x.setTitle("");
        getConfiguration().addxAxis(x);

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setAlign(HorizontalAlign.LEFT);
        legend.setFloating(true);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setX(150);
        legend.setY(100);
        legend.setBorderWidth(1);
        legend.setBackgroundColor(new SolidColor("#ffffff"));
        getConfiguration().setLegend(legend);

        PlotOptionsArea plotOptions = new PlotOptionsArea();
        plotOptions.setFillOpacity(0.5);
        getConfiguration().setPlotOptions(plotOptions);


        ListSeries ls = new ListSeries();

        ls.setName("Critical");
        ls.setData( 0, 1, 4, 4, 5, 2, 3, 7);
        getConfiguration().addSeries(ls);

        ls = new ListSeries();
        ls.setName("Blocker");
        ls.setData(1, 0, 3, 0, 3, 1, 2, 1);
        getConfiguration().addSeries(ls);


    }
}
