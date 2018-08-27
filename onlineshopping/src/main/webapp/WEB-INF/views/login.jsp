<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">

	<div class="row">
	
			<c:if test="${not empty message}">
	
				<div class="col-xs-12" style="margin-left: 12%;">
					<div class="alert alert-success alert-dismissable">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						${message}
					</div>
				</div>
	
			</c:if>

		<div class="col-sm-8 col-sm-offset-2" style="margin-left: 12%;">

			<div class="card">
				<div class="card-header">
					<h4>Login</h4>
				</div>
				<div class="card-body">

					<!-- Form Elements -->
					
					<form class="form-horizontal"  action="${contextRoot}/manage/doLogin" method="POST" >
    						<div class="container">
        						<div class="row">
           							 <div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="name" class="col-sm-4 col-form-label">Email: </label>
                    						 <div class="col-sm-8">
                        						<input type="text" name="email" path="name" id="email" placeholder="Email here ..." class="form-control" /> 
												<sf:errors path="email" cssClass="help-block" element="em" />
												<!-- <em class="help-block">Please enter Product Name</em> -->
                    						</div>
                						</div>
            						</div>
            						 <div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="brand" class="col-sm-4 col-form-label">Password: </label>
                    						 <div class="col-sm-8">
                        						<input type="text" name="password" path="password" id="password" placeholder="Password here ..." class="form-control" /> 
												<sf:errors path="password" cssClass="help-block" element="em" />
												<!-- <em class="help-block">Please enter Brand Name</em> -->
                    						</div>
                						</div>
            						</div>
            						
            						<div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							     <div class="col-sm-8">
                        						<button  path="brand" id="button"  class="btn btn-primary">Submit</button>
												<sf:errors path="brand" cssClass="help-block" element="em" />
												<!-- <em class="help-block">Please enter Brand Name</em> -->
                    						</div>
                						</div>
            						</div>
            					       
            
            				  </div>
           				 </div>
           			 </form>
            
				</div>
			</div>
		</div>
	</div>



	
	

</div>
