
<div class="container">
	<div class="row">
		<!-- TO display side bar -->
		<div class="col-md-3">
			<%@include file="./common/sidebar.jsp"%>
		</div>
		<!-- TO display actually products -->
		<div class="col-md-9">
			<!-- Adding breadcrum component -->
			<div class="row">
				<div class="col-lg-12">


					<c:if test="${userclickAllProducts==true}">
						<table>
							<tr>
								<td><a href="${contextRoot}/home">Home</a></td>
								<td>/<a class="active">AllProducts</a></td>
								<td></td>
							</tr>
						</table>

					</c:if>
					<c:if test="${userclickCategoryProducts==true}">
						<table>
							<tr>
								<td><a href="${contextRoot}/home">Home</a></td>
								<td>/<a class="active">AllProducts</a></td>
								<td><a class="active">/${category.name}</td>
							</tr>
						</table>
					</c:if>
				</div>

			</div>
		</div>

	</div>
</div>