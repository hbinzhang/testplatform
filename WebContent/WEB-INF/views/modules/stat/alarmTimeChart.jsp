<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>故障时长图表统计</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.10.2.min.js"></script>
	<script src="${ctxStatic}/highcharts/highcharts.js"></script>
	<script src="${ctxStatic}/highcharts/highcharts-more.js"></script>
	<script src="${ctxStatic}/highcharts/modules/exporting.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#container2').highcharts({
	            chart: {
	                type: 'column'
	            },
	            title: {
	                text: '故障时长图表统计'
	            },
	            xAxis: {
	                /* categories: ['海淀桥', '七里庄', '大红门', '北京SCA', '定慧桥'] */
	                ${nenames}
	            },
	            yAxis: {
	                min: 0,
	                title: {
	                    text: '故障时长：小时'
	                },
	                stackLabels: {
	                    enabled: true,
	                    style: {
	                        fontWeight: 'bold',
	                        color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
	                    }
	                }
	            },
	            legend: {
	                align: 'right',
	                x: -70,
	                verticalAlign: 'top',
	                y: 20,
	                floating: true,
	                backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
	                borderColor: '#CCC',
	                borderWidth: 1,
	                shadow: false
	            },
	            tooltip: {
	                formatter: function() {
	                    return '<b>'+ this.x +'</b><br/>'+
	                        this.series.name +': '+ this.y +'<br/>';
	                }
	            },
	            plotOptions: {
	                column: {
	                    stacking: 'normal',
	                    dataLabels: {
	                        enabled: true,
	                        color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
	                        style: {
	                            textShadow: '0 0 3px black, 0 0 3px black'
	                        }
	                    }
	                }
	            },
	            series: [{
	                name: '时长',
	                /* data: [5, 3, 4, 7, 2] */
	                ${alarmtimes}
	            }]
	        });
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/stat/alarm/table">表格</a></li>
		<li><a href="${ctx}/stat/alarm/chart">数量统计图</a></li>
		<li class="active"><a href="#">时长统计图</a></li>
	</ul><br/>
	<div id="container2" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</html>