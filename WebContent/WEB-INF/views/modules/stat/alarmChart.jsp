<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>告警级别图表统计</title>
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
	                text: '告警级别图表统计'
	            },
	            xAxis: {
	            	${nenames}
	            },
	            yAxis: {
	                min: 0,
	                title: {
	                    text: '告警数量：个'
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
	                        this.series.name +': '+ this.y +'<br/>'+
	                        '总数: '+ this.point.stackTotal;
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
	            colors: ['#FF0000', '#FF6633', '#FFC800', '#0000FF'] ,
	            series: [{
	                name: '严重',
	                <%-- <%
	        		if (2 > 1) {
		        	%>
		        	data: [5, 3, 4, 7, 2]
		        	<%
		        		} else {
		        	%>
	            	data: [1, 1, 1, 1, 1]
		        	<%
		        		}
		        	%> --%>
		        	
		        	/* <c:choose>
		        	<c:when test="${0 == 0}">
		        	data: [5, 3, 4, 7, 2]
		        	</c:when>
		        	<c:otherwise>
		        	data: [1, 1, 1, 1, 1]
		        	</c:otherwise>
		        	</c:choose> */
		        	${criCount}
	            }, {
	                name: '主要',
	                ${majCount}
	            }, {
	                name: '次要',
	                ${minCount}
	            }, {
	                name: '警告',
	                ${warCount}
	            }]
	        });
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/stat/alarm/table">表格</a></li>
		<li class="active"><a href="#">数量统计图</a></li>
		<li><a href="${ctx}/stat/alarm/timechart">时长统计图</a></li>
	</ul><br/>
	<div id="container2" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</html>