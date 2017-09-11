package com.vaadin.demo.dashboard.component.chart;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;


@SuppressWarnings("serial")
public class DefectConvergenceChart extends Chart {


    public DefectConvergenceChart(){

        getConfiguration().getChart().setType(ChartType.COLUMN);

        getConfiguration().setTitle("Плотность дефектов на 1000 строк кода");

        XAxis x = new XAxis();
        x.setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec");
        getConfiguration().addxAxis(x);

        YAxis y = new YAxis();
        y.setTitle("");
        y.setMin(0);
        getConfiguration().addyAxis(y);

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setBackgroundColor(new SolidColor("#FFFFFF"));
        legend.setAlign(HorizontalAlign.LEFT);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setX(100);
        legend.setY(70);
        legend.setFloating(true);
        legend.setShadow(true);
        getConfiguration().setLegend(legend);

        Tooltip tooltip = new Tooltip();
        getConfiguration().setTooltip(tooltip);

        PlotOptionsColumn plot = new PlotOptionsColumn();
        plot.setPointPadding(0.2);
        plot.setBorderWidth(0);


        ListSeries ls = new ListSeries();
        ls.setName("Плотность дефектов");
        ls.setData(49.9, 71.5, 106.4, 129.2, 144.0,
                176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4);
        getConfiguration().addSeries(ls);


    }
}
