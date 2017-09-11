package com.vaadin.demo.dashboard.component.chart;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;


@SuppressWarnings("serial")
public class DefectDensityChart extends Chart {


    public DefectDensityChart(){

        getConfiguration().getChart().setType(ChartType.LINE);

        getConfiguration().setTitle("График сходимости дефектов");


        getConfiguration().getxAxis().setCategories("Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        YAxis yAxis =  getConfiguration().getyAxis();
        yAxis.setTitle(new AxisTitle("Количество дефектов"));

        getConfiguration()
                .getTooltip()
                .setFormatter(
                        "'<b>'+ this.series.name +'</b><br/>'+this.x +': '+ this.y +'°C'");

        PlotOptionsLine plotOptions = new PlotOptionsLine();
        plotOptions.setDataLabels(new DataLabels(true));
        plotOptions.setEnableMouseTracking(false);
        getConfiguration().setPlotOptions(plotOptions);

        ListSeries ls = new ListSeries();
        ls.setName("Количество открытых дефектов");
        ls.setData(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3,
                13.9, 9.6);
        getConfiguration().addSeries(ls);

        ls = new ListSeries();
        ls.setName("Количество закрытых дефектов");
        ls.setData(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6,
                4.8);
        getConfiguration().addSeries(ls);

    }
}
