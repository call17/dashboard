package com.vaadin.demo.dashboard.component.chart;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;


@SuppressWarnings("serial")
public class MTTRChart extends Chart {


    public MTTRChart(){

        getConfiguration().getChart().setType(ChartType.LINE);

        getConfiguration().setTitle("MTTR");

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

        PlotOptionsLine plotOptions = new PlotOptionsLine();
        plotOptions.setDataLabels(new DataLabels(true));
        plotOptions.setEnableMouseTracking(false);
        getConfiguration().setPlotOptions(plotOptions);


        ListSeries ls = new ListSeries();
        ls.setName("Среднее время исправления блокирующих и критических дефектов");
        ls.setData(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3,
                13.9, 9.6);
        getConfiguration().addSeries(ls);



    }
}
