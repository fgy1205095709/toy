(function ($) {
    'use strict';
    $(function () {
        Chart.defaults.global.legend.labels.usePointStyle = true;


        if ($("#visit-sale-chart").length) {
            Chart.defaults.global.legend.labels.usePointStyle = true;
            var ctx = document.getElementById('visit-sale-chart').getContext("2d");

            var gradientStrokeViolet = ctx.createLinearGradient(0, 0, 0, 181);
            gradientStrokeViolet.addColorStop(0, 'rgba(218, 140, 255, 1)');
            gradientStrokeViolet.addColorStop(1, 'rgba(154, 85, 255, 1)');
            var gradientLegendViolet = 'linear-gradient(to right, rgba(218, 140, 255, 1), rgba(154, 85, 255, 1))';

            var gradientStrokeBlue = ctx.createLinearGradient(0, 0, 0, 360);
            gradientStrokeBlue.addColorStop(0, 'rgba(54, 215, 232, 1)');
            gradientStrokeBlue.addColorStop(1, 'rgba(177, 148, 250, 1)');
            var gradientLegendBlue = 'linear-gradient(to right, rgba(54, 215, 232, 1), rgba(177, 148, 250, 1))';

            var gradientStrokeRed = ctx.createLinearGradient(0, 0, 0, 300);
            gradientStrokeRed.addColorStop(0, 'rgba(255, 191, 150, 1)');
            gradientStrokeRed.addColorStop(1, 'rgba(254, 112, 150, 1)');
            var gradientLegendRed = 'linear-gradient(to right, rgba(255, 191, 150, 1), rgba(254, 112, 150, 1))';

            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期天'],
                    datasets: [
                        {
                            label: "访问量",
                            borderColor: gradientStrokeViolet,
                            backgroundColor: gradientStrokeViolet,
                            hoverBackgroundColor: gradientStrokeViolet,
                            legendColor: gradientLegendViolet,
                            pointRadius: 0,
                            fill: false,
                            borderWidth: 1,
                            fill: 'origin',
                            data: [100, 203, 152, 335, 254, 305, 150]
                        },
                        {
                            label: "文章数",
                            borderColor: gradientStrokeRed,
                            backgroundColor: gradientStrokeRed,
                            hoverBackgroundColor: gradientStrokeRed,
                            legendColor: gradientLegendRed,
                            pointRadius: 0,
                            fill: false,
                            borderWidth: 1,
                            fill: 'origin',
                            data: [200, 202, 424, 600, 601, 820, 1030]
                        },
                        {
                            label: "用户数",
                            borderColor: gradientStrokeBlue,
                            backgroundColor: gradientStrokeBlue,
                            hoverBackgroundColor: gradientStrokeBlue,
                            legendColor: gradientLegendBlue,
                            pointRadius: 0,
                            fill: false,
                            borderWidth: 1,
                            fill: 'origin',
                            data: [12, 12, 12, 12, 12,12, 25]
                        }
                    ]
                },
                options: {
                    responsive: true,
                    legend: false,
                    legendCallback: function (chart) {
                        var text = [];
                        text.push('<ul>');
                        for (var i = 0; i < chart.data.datasets.length; i++) {
                            text.push('<li><span class="legend-dots" style="background:' +
                                chart.data.datasets[i].legendColor +
                                '"></span>');
                            if (chart.data.datasets[i].label) {
                                text.push(chart.data.datasets[i].label);
                            }
                            text.push('</li>');
                        }
                        text.push('</ul>');
                        return text.join('');
                    },
                    scales: {
                        yAxes: [{
                            ticks: {
                                display: false,
                                min: 40,
                                stepSize: 80,
                                max: 800
                            },
                            gridLines: {
                                drawBorder: false,
                                color: 'rgba(235,237,242,1)',
                                zeroLineColor: 'rgba(235,237,242,1)'
                            }
                        }],
                        xAxes: [{
                            gridLines: {
                                display: false,
                                drawBorder: false,
                                color: 'rgba(0,0,0,1)',
                                zeroLineColor: 'rgba(235,237,242,1)'
                            },
                            ticks: {
                                padding: 20,
                                fontColor: "#9c9fa6",
                                autoSkip: true,
                            },
                            categoryPercentage: 0.5,
                            barPercentage: 0.5
                        }]
                    }
                },
                elements: {
                    point: {
                        radius: 0
                    }
                }
            })
            $("#visit-sale-chart-legend").html(myChart.generateLegend());
        }
        var f2 = $(".f2").val();
        var f3 = $(".f3").val();
        var f4 = $(".f4").val();
        var f5 = $(".f5").val();
        var f6 = $(".f6").val();
        var f7 = $(".f7").val();
        var f8 = $(".f8").val();
        var f9 = $(".f9").val();
        var f10 = $(".f10").val();
        var f11 = $(".f11").val();
        var f12 = $(".f12").val();
        if ($("#traffic-chart").length) {
            var gradientStrokeBlue = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokeBlue.addColorStop(0, 'rgba(54, 215, 232, 1)');
            gradientStrokeBlue.addColorStop(1, 'rgba(177, 148, 250, 1)');
            var gradientLegendBlue = 'linear-gradient(to right, rgba(54, 215, 232, 1), rgba(177, 148, 250, 1))';


            var gradientStrokeRed = ctx.createLinearGradient(0, 0, 0, 130);
            gradientStrokeRed.addColorStop(0, 'rgba(255, 191, 150, 1)');
            gradientStrokeRed.addColorStop(1, 'rgba(254, 112, 150, 1)');
            var gradientLegendRed = 'linear-gradient(to right, rgba(255, 191, 150, 1), rgba(254, 112, 150, 1))';

            var gradientStrokeGreen = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokeGreen.addColorStop(0, 'rgba(6, 185, 157, 1)');
            gradientStrokeGreen.addColorStop(1, 'rgba(10,255,45, 1)');
            var gradientLegendGreen = 'linear-gradient(to right, rgba(6, 185, 157, 1), rgba(10,255,45, 1))';

            var gradientStrokeLightBlue = ctx.createLinearGradient(0, 0, 0, 150);
            gradientStrokeLightBlue.addColorStop(0, 'rgba(158,255,247, 1)');
            gradientStrokeLightBlue.addColorStop(1, 'rgba(55,153,228, 1)');
            var gradientLegendLightBlue = 'linear-gradient(to right, rgba(158,255,247, 1), rgba(55,153,228, 1))';


            var gradientStrokePurple = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokePurple.addColorStop(0, 'rgba(228,180,252, 1)');
            gradientStrokePurple.addColorStop(1, 'rgba(164,95,251, 1)');
            var gradientLegendPurple = 'linear-gradient(to right, rgba(228,180,252, 1), rgba(164,95,251, 1))';
            var gradientStrokeYello = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokeYello.addColorStop(0, 'rgba(233,255,135, 1)');
            gradientStrokeYello.addColorStop(1, 'rgba(255,247,23, 1)');
            var gradientLegendYello = 'linear-gradient(to right, rgba(233,255,135, 1), rgba(255,247,23, 1))';

            var gradientStrokeOrange = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokeOrange.addColorStop(0, 'rgba(233,255,135, 1)');
            gradientStrokeOrange.addColorStop(1, 'rgba(255,113,58, 1)');
            var gradientLegendOrange = 'linear-gradient(to right, rgba(233,255,135, 1), rgba(255,113,58, 1))';

            var gradientStrokeCold = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokeCold.addColorStop(0, 'rgba(139,210,212, 1)');
            gradientStrokeCold.addColorStop(1, 'rgba(0,69,130, 1)');
            var gradientLegendCold = 'linear-gradient(to right, rgba(139,210,212, 1), rgba(0,69,130, 1))';

            var gradientStrokeWhite = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokeWhite.addColorStop(0, 'rgba(235,222,207, 1)');
            gradientStrokeWhite.addColorStop(1, 'rgba(222,204,185, 1)');
            var gradientLegendWhite = 'linear-gradient(to right, rgba(235,222,207, 1), rgba(222,204,185, 1))';

            var gradientStrokeTick = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokeTick.addColorStop(0, 'rgba(198,112,165, 1)');
            gradientStrokeTick.addColorStop(1, 'rgba(80,26,68, 1)');
            var gradientLegendTick = 'linear-gradient(to right, rgba(198,112,165, 1), rgba(80,26,68, 1))';

            var gradientStrokePink = ctx.createLinearGradient(0, 0, 0, 50);
            gradientStrokePink.addColorStop(0, 'rgba(251,209,215, 1)');
            gradientStrokePink.addColorStop(1, 'rgba(238,129,153, 1)');
            var gradientLegendPink = 'linear-gradient(to right, rgba(251,209,215, 1), rgba(238,129,153, 1))';
            var trafficChartData = {
                datasets: [{
                    data: [f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12],
                    backgroundColor: [
                        gradientStrokeBlue,
                        gradientStrokeGreen,
                        gradientStrokeRed,
                        gradientStrokeLightBlue,
                        gradientStrokePurple,
                        gradientStrokeYello,
                        gradientStrokeOrange,
                        gradientStrokeCold,
                        gradientStrokeWhite,
                        gradientStrokeTick,
                        gradientStrokePink
                    ],
                    hoverBackgroundColor: [
                        gradientStrokeBlue,
                        gradientStrokeGreen,
                        gradientStrokeRed,
                        gradientStrokeLightBlue,
                        gradientStrokePurple,
                        gradientStrokeYello,
                        gradientStrokeOrange,
                        gradientStrokeCold,
                        gradientStrokeWhite,
                        gradientStrokeTick,
                        gradientStrokePink
                    ],
                    borderColor: [
                        gradientStrokeBlue,
                        gradientStrokeGreen,
                        gradientStrokeRed,
                        gradientStrokeLightBlue,
                        gradientStrokePurple,
                        gradientStrokeYello,
                        gradientStrokeOrange,
                        gradientStrokeCold,
                        gradientStrokeWhite,
                        gradientStrokeTick,
                        gradientStrokePink
                    ],
                    legendColor: [
                        gradientLegendBlue,
                        gradientLegendGreen,
                        gradientLegendRed,
                        gradientLegendLightBlue,
                        gradientLegendPurple,
                        gradientLegendYello,
                        gradientLegendOrange,
                        gradientLegendCold,
                        gradientLegendWhite,
                        gradientLegendTick,
                        gradientLegendPink
                    ]
                }],

                // These labels appear in the legend and in the tooltips when hovering different arcs
                labels: [
                    '时尚', '美食', '科技', '旅游', '游戏', '美妆', '运动', '读书', '动漫', '影视', '编程'
                ]
            };
            var trafficChartOptions = {
                responsive: true,
                animation: {
                    animateScale: true,
                    animateRotate: true
                },
                legend: false,
                legendCallback: function (chart) {
                    var text = [];
                    text.push('<ul>');
                    for (var i = 0; i < trafficChartData.datasets[0].data.length; i++) {
                        text.push('<li><span class="legend-dots" style="background:' +
                            trafficChartData.datasets[0].legendColor[i] +
                            '"></span>');
                        if (trafficChartData.labels[i]) {
                            text.push(trafficChartData.labels[i]);
                        }
                        text.push('<span class="float-right">' + trafficChartData.datasets[0].data[i] + '</span>')
                        text.push('</li>');
                    }
                    text.push('</ul>');
                    return text.join('');
                }
            };
            var trafficChartCanvas = $("#traffic-chart").get(0).getContext("2d");
            var trafficChart = new Chart(trafficChartCanvas, {
                type: 'doughnut',
                data: trafficChartData,
                options: trafficChartOptions
            });
            $("#traffic-chart-legend").html(trafficChart.generateLegend());
        }
        if ($("#inline-datepicker").length) {
            $('#inline-datepicker').datepicker({
                enableOnReadonly: true,
                todayHighlight: true,
            });
        }

        var doughnutPieData = {
            datasets: [{
                data: [10, 40, 30,20],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(255, 206, 86, 0.5)',
                    'rgba(75, 192, 192, 0.5)',
                    'rgba(153, 102, 255, 0.5)',
                    'rgba(255, 159, 64, 0.5)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
            }],

            // These labels appear in the legend and in the tooltips when hovering different arcs
            labels: [
                '<18',
                '19-30',
                '30-50',
                '>50'
            ]
        };
        var doughnutPieOptions = {
            responsive: true,
            animation: {
                animateScale: true,
                animateRotate: true
            }
        };

        if ($("#pieChart").length) {
            var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
            var pieChart = new Chart(pieChartCanvas, {
                type: 'pie',
                data: doughnutPieData,
                options: doughnutPieOptions
            });
        }
    });
})(jQuery);