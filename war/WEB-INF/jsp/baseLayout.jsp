<%@ page pageEncoding="UTF-8"%>
<%@ include file="include-preceding-html.jsp"%>

<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="head-includes" />
</head>

<body>
<div id="page" class="with-sidebar">
	<div id="header-wrap">
		<div id="header" class="block-content">
			<div id="pagetitle">
				<h1 class="logo"><a href="<c:url value="index.jsp"/>">SVJ Navigátorů 600-603</a></h1>
				<div class="clear"></div>
			</div>
			
			<!-- main navigation -->
			<div id="nav-wrap1">
				<div id="nav-wrap2">
					<ul id="nav">
						<tiles:insertAttribute name="main-navigation" />
					</ul>
				</div>
			</div>
			<!-- /main navigation -->
		
		</div>
		
		<!-- main content and sidebar -->
		<div id="main-wrap1">
			<div id="main-wrap2">
				<div id="main" class="block-content">
					<div class="mask-main rightdiv">
						<div class="mask-left">
							<div class="col1">
								<div id="main-content">
									<tiles:insertAttribute name="main-content" />
								</div>
							</div>
							<div class="col2">
								<ul id="sidebar">
									<tiles:insertAttribute name="sidebar" />
								</ul>
							</div>
						</div>
					</div>
					<div class="clear-content"></div>
				</div>
			</div>
		</div>
		<!-- /main content and sidebar -->
	</div>

	<!-- footer -->
	<div id="footer">
		<div class="block-content">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<!-- /footer -->
</div>
</body>
</html>
