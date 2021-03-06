package com.vaadin.demo.dashboard.component.sparkline;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.demo.dashboard.data.dummy.DummyDataGenerator;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class SparklineChartPie extends VerticalLayout {

    public SparklineChartPie(final String name, final Color color, final int howManyPoints,
                             final int min, final int max) {
        setSizeUndefined();
        addStyleName("spark");
        setMargin(false);
        setSpacing(false);
        setDefaultComponentAlignment(Alignment.TOP_CENTER);

        int[] values = DummyDataGenerator.randomSparklineValues(howManyPoints,
                min, max);


        Label title = new Label(name);
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_SMALL);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        addComponent(title);

        addComponent(buildSparkline(values, color));


    }

    private Component buildSparkline(final int[] values, final Color color) {
        Chart spark = new Chart();
        spark.getConfiguration().setTitle("");
        spark.getConfiguration().getChart().setType(ChartType.PIE);
        spark.getConfiguration().getChart().setAnimation(false);
        spark.setWidth("150px");
        spark.setHeight("100px");


        spark.getConfiguration().setCredits(new Credits(false));

        PlotOptionsPie opts = new PlotOptionsPie();
        opts.setAllowPointSelect(true);
        opts.setCursor(Cursor.POINTER);
        opts.setDataLabels(new DataLabels(false));
        spark.getConfiguration().setPlotOptions(opts);


        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Critical",5));
        series.add(new DataSeriesItem("Blocker",2));


        spark.getConfiguration().addSeries(series);



        return spark;
    }


}
