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
public class SparklineChartColumn extends VerticalLayout {

    public SparklineChartColumn(final String name, final Color color, final int howManyPoints,
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
        spark.getConfiguration().getChart().setType(ChartType.COLUMN);
        spark.getConfiguration().getChart().setAnimation(false);
        spark.setWidth("120px");
        spark.setHeight("60px");

        DataSeries series = new DataSeries();
        for (int i = 0; i < values.length; i++) {
            DataSeriesItem item = new DataSeriesItem("", values[i]);
            series.add(item);
        }
        spark.getConfiguration().setSeries(series);
        spark.getConfiguration().getTooltip().setEnabled(false);

        Configuration conf = series.getConfiguration();
        Legend legend = new Legend();
        legend.setEnabled(false);
        conf.setLegend(legend);

        Credits c = new Credits("");
        spark.getConfiguration().setCredits(c);

        PlotOptionsLine opts = new PlotOptionsLine();
        opts.setAllowPointSelect(false);
        opts.setColor(color);
        opts.setDataLabels(new DataLabels(false));
        opts.setLineWidth(1);
        opts.setShadow(false);
        opts.setDashStyle(DashStyle.SOLID);
        opts.setMarker(new Marker(false));
        opts.setEnableMouseTracking(false);
        opts.setAnimation(false);
        spark.getConfiguration().setPlotOptions(opts);

        XAxis xAxis = spark.getConfiguration().getxAxis();
        YAxis yAxis = spark.getConfiguration().getyAxis();

        SolidColor transparent = new SolidColor(0, 0, 0, 0);

        xAxis.setLabels(new Labels(false));
        xAxis.setTickWidth(0);
        xAxis.setLineWidth(0);

        yAxis.setTitle(new AxisTitle(""));
        yAxis.setAlternateGridColor(transparent);
        yAxis.setLabels(new Labels(false));
        yAxis.setLineWidth(0);
        yAxis.setGridLineWidth(0);

        return spark;
    }
}
