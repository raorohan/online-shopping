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
					<h4>Product Management</h4>
				</div>
				<div class="card-body">

					<!-- Form Elements -->
					
					<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products"
					method="POST"
					enctype="multipart/form-data"
					>
    						<div class="container">
        						<div class="row">
           							 <div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="name" class="col-sm-4 col-form-label">Enter Product Name: </label>
                    						 <div class="col-sm-8">
                        						<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control" /> 
												<sf:errors path="name" cssClass="help-block" element="em" />
												<!-- <em class="help-block">Please enter Product Name</em> -->
                    						</div>
                						</div>
            						</div>
            						<div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="brand" class="col-sm-4 col-form-label">Enter Brand Name: </label>
                    						 <div class="col-sm-8">
                        						<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control" /> 
												<sf:errors path="brand" cssClass="help-block" element="em" />
												<!-- <em class="help-block">Please enter Brand Name</em> -->
                    						</div>
                						</div>
            						</div>
            						
            						<div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="description" class="col-sm-4 col-form-label">Product Description: </label>
                    						 <div class="col-sm-8">
                        						<sf:textarea path="description" id="description" placeholder="Product Description" class="form-control rounder-0" rows="5" ></sf:textarea> 
												<sf:errors path="description" cssClass="help-block" element="em" />
												<!-- <em class="help-block">Please enter Product Description</em> -->
                    						</div>
                						</div>
            						</div>
            						
            						<div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="price" class="col-sm-4 col-form-label">Enter Unit Price: </label>
                    						 <div class="col-sm-8">
                        						<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price &#8377;" class="form-control" /> 
												<sf:errors path="unitPrice" cssClass="help-block" element="em" />
												<!-- <em class="help-block">Please enter Unit Price</em> -->
                    						</div>
                						</div>
            						</div>
            						
            						<div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="quantity" class="col-sm-4 col-form-label">Quantity Available: </label>
                    						 <div class="col-sm-8">
                        						<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control" /> 
												<!-- <em class="help-block">Please enter Quantity Available</em> -->
                    						</div>
                						</div>
            						</div>
            						<!-- File Upload -->
            						<div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="file" class="col-sm-4 col-form-label">Select an Image: </label>
                    						 <div class="col-sm-8">
                        						<sf:input type="file" path="file" id="file" class="form-control" /> 
                        						<sf:errors path="file" cssClass="help-block" element="em" />
												<!-- <em class="help-block">Please enter Quantity Available</em> -->
                    						</div>
                						</div>
            						</div>
            						
            						<div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 <label for="quantity" class="col-sm-4 col-form-label">Select Category: </label>
                    						 <div class="col-sm-8">
                        						<sf:select path="categoryId" id="categoryId" class="form-control"
                        						
                        						items="${categories}"
                        						itemLabel="name"
                        						itemValue="id"
                        						 />
                        						
                        						<!-- <option value="1" selected>Category One</option>
                        						<option value="2" >Category Two</option>
                        						<option value="3" >Category Three</option> -->
                        						
												<!-- <em class="help-block">Please enter Quantity Available</em> -->
                    						</div>
                						</div>
            						</div>
            						
            						<div class="form-group form-group-sm col-sm-12">
                						<div class="row">
                   							 
                    						 <div class="col-sm-8 col-md-offset-4">
                        						<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary" /> 
                        						
                        						<!-- Hidden fields -->
                        						<sf:hidden path="id" />
                        						<sf:hidden path="code" />
                        						<sf:hidden path="active" />
                        						<sf:hidden path="supplierId" />
                        						<sf:hidden path="purchases" />
                        						<sf:hidden path="views" />
                    						</div>
                						</div>
            						</div>
            
            								
            
            
            
            
            				  </div>
           				 </div>
           			 </sf:form>
            
            

					
				</div>
			</div>
		</div>
	</div>
</div>