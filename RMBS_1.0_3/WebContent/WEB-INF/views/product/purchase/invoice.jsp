<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>


	<!DOCTYPE html>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>INVOICE COPY</title>
	<script type="text/javascript" charset="utf-8" src="js/print.js"></script>
	<style type="text/css">
	table {
		border-spacing: 0px;
		font-style: Calibri;
		
	}
	td{
	padding:0;
		word-wrap: break-word;
		
	}
	.inv_print {
		width: 100%;
		margin: auto;
		font-size: 14px;
		border: 0.5px solid #454545;
		
		background-color: #fff;
	}

	.inv_print table {
		width: 100%;
	}
	.sup_details_1_1{
		width: 70%;
	}

	.inv_print .inv_header td {
		text-align: center;
		vertical-align: middle;
		font-size: 20px;
		font-weight: bold;
		padding-bottom: 10px;
		padding-top: 10px;
	}
	.inv_print .sup_details{
	
	}

	.inv_print .sup_details table table .lable {
		width: 30%;
		
	}
	 .lable {
	 font-weight: bold;
	 }
	.inv_print .sup_details table table {
		height: 100%;
	}

	.inv_print .rec_details table td {
		width: 30%;
	}

	.inv_print .rec_details table table .lable {
		width: 30%;
	}

	.inv_items_header table td,.inv_items_header table table td {
		text-align: center;
	}

	.inv_items table td,.inv_items table table td {
		text-align: center;
	}

	.inv_items table table {
		border: none;
	}

	.hslno,.slno {
		width: 5%;
	}

	.hdesc{
		width: 35%

	}
	.desc {
		width: 35%
	}
	.inv_items .desc, {
		text-align: left;
		padding-left: 5px;
	}

	.hsch,.hmrp,.hpr {
		width: 7%

	}
	.sch,.mrp,.pr {
		width: 7%
	}
	.hquta {
		width: 17%;
		 font-weight: bold;
	}
	.quta,.fquta{
		
		width: 7%
	}
	.amt,.ps{
	width: 8%
	}

	.inv_items_header .lable{
	 font-weight: bold;
	 color: #346969;
	}
	.pay_amnt,.tot_vat,.ovr_dis,.grand_tot{
	
	}

	/***********************************************************************/
	.sup_details_1{
	border-top: 0.5px solid #454545;
	}
	.sup_details_1_1{
	border-right: 0.5px solid #454545;
	}
	.rec_details_1{
	border-top: 0.5px solid #454545;
	}
	.rec_details_1_1{
	border-right: 0.5px solid #454545;
	}
	.inv_items_header_1{
	border-top: 0.5px solid #454545;

	}
	tr.inv_items_header_1_1 td {
	border-bottom: 0.5px solid #454545;
	}

	.hsch,.hmrp,.hpr,.hquta,.hslno,.hdesc {
		border-right: 0.5px solid #454545;
		 color: #346969;
	}
	.sch,.mrp,.pr,.quta,.slno,.desc,.fquta {
		border-right: 0.5px solid #454545;
padding-top:1px;
		padding-bottom:1px;
	}
	tr.hquta_1 td{
	border-bottom: none;
	}
	tr.amnt_1 td{
	border-bottom: none;
	}
	.inv_items_1{
	border-top: 0.5px solid #454545;
	}
	/*.slno,.desc,.sch,.mrp,.quta_1,.quta_2,.pr,.pr_1{
	border-right: 0.5px solid #454545;

	}*/
	.inv_cal_1{
	border-top: 0.5px solid #454545;
	}
	.inv_cal_1_1{
	border-right: 0.5px solid #454545;
	}
	.inv_cal_1_1_1{
	border-top: 0.5px solid #454545;
	border-right: 0.5px solid #454545;
	}
	.inv_cal_1_1_2{
	border-top: 0.5px solid #454545;
	}
	.inv_tc_1{
	border-top: 0.5px solid #454545;
	}
	.inv_tc_1_1{
	border-right: 0.5px solid #454545;
	}

	tr.inv_items_footer_1 td{
	border-top: 0.5px solid #454545;
	}
	
	.tot_qua{
		border-right: 0.5px solid #454545;
		}
		.inv_items_footer_1 td{
		border-bottom: 0.5px solid #454545;
		}
	/************************************************************/

	.lable,.inv_tc_1_1,.inv_header{
	 color: #346969;
	 padding-top:3px;
		padding-bottom:3px;
		padding-left: 2px;
	}
	.inv_print .printLinks{
	width: 100%;
	}
	.printLinks{
	text-align: right;
	background-image: url(images/green.png);
	vertical-align: middle;
	}
	.printLinks .close{
	color: #FFF;
	font-weight: bold;
	
	padding: 6px;
	}
	.print{
	padding: 3px;
	}
	</style>
<%--<style type="text/css" media="print">
        @page 
        {
            size: auto;   /* auto is the current printer page size */
            margin: 0mm;  /* this affects the margin in the printer settings */
        }

        body 
        {
            background-color:#FFFFFF; 
            border: solid 1px black ;
            margin: 0px;  /* the margin on the content before printing */
       }
</style> --%>
	<script type="text/javascript">
	$(function(){
		//alert("hi");
		$( ".print" )
			.attr( "href", "javascript:void( 0 )" )
			.click(
				function(){
					//alert("inside print");
					$( ".printable" ).print();
						return( false );
				});
		});
	   $(function(){
      		//alert("closing");
      		$( ".close" )
      			.attr( "href", "javascript:void( 0 )" )
      			.click(
      				function(){
      					$(".orderLIst").replaceWith(divClone); 
      					$(".purchase_container").replaceWith(divClone); 
      					location.reload(true);
      						return( false );
      				});
      		});
	 
	</script>
	</head>
	<body class="inv_print_background" id="">
	<div class="printLinks"><a class="print" title="Prin Invoice Copy"><img src="images/print2.png" alt="print" height="20px" width="20px" /></a>&nbsp;<a class="close" title="Back">X</a></div>
	<div class="printable">
		<table class="inv_print" style="border-spacing: 0px;">
		<tr>
      <%--<a href="#" onClick="window.print();" class=".print">Print</a> --%>		
		</tr>
			<tr class="inv_header">
				<td>TAX INVOICE</td>
			</tr>
			<tr class="sup_details">
				<td class="sup_details_1">
					<table>
						<tr>
							<td class="sup_details_1_1">
								<table class="">
									<tr>
										<td class="lable">SUPPLIER :</td>
										<td><c:out value="${PODetails.agencyBean.agencyName}"></c:out></td>
									</tr>
									<tr>
										<td class="lable">ADDRESS :</td>
										<td><c:out value="${PODetails.agencyBean.resourceBean.addressBean.address}"></c:out></td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td class="lable">TIN NO :</td>
									</tr>
									<tr>
										<td><c:out value="${PODetails.agencyBean.cstNo}"></c:out></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr class="rec_details">
				<td  class="rec_details_1">
					<table>
						<tr>
							<td   class="rec_details_1_1">
								<table>
									<tr>
										<td class="lable">M/S:</td>
									</tr>
									<tr>
										<td><c:out value="${PODetails.branchBean.name}"></c:out>,</td>
									</tr>
									<tr>
										<td><c:out value="${PODetails.branchBean.resourceBean.addressBean.address}"></c:out></td>
									</tr>
								</table>
							</td>
							<td  class="rec_details_1_1">
								<table >
									<tr>
										<td class="lable">BILL NO:</td>
											<td><c:out value="${PODetails.orderIdByDate}"></c:out></td>
									</tr>
									<tr>
										<td class="lable">DEALER CODE:</td>
										<td>AG00${PODetails.agencyBean.id}</td>
									</tr>
									<tr>
										<td class="lable">P.O NO:</td>
										<td><c:out value="${PODetails.orderIdByDate}"></c:out></td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td class="lable">DATE:</td>
										<td><c:out value="${PODetails.billingDateAndTime}"></c:out></td>
									</tr>
									<tr>
										<td class="lable">CHECKED BY:</td>
										<td>XXXXXXX</td>
									</tr>
									<tr>
										<td class="lable">TRANSPORT:</td>
										<td>XXXXXXXX</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr class="inv_items_header">
				<td class="inv_items_header_1">
					<table>
						<tr class="inv_items_header_1_1">
							<td class="hslno"><b>SL NO</b></td>
							<td class="hdesc" colspan="2"><b>DESCRIPTION</b></td>
							<td class="hsch"><b>DISCOUNT</b></td>
							<td class="hmrp"><b>MRP</b></td>
							<td colspan="2" class="hquta">
								<table>
									<tr>
										<td colspan="2"  class="lable">QUANTITY</td>
									</tr>
									<tr class="hquta_1">
										<td class="lable">SALE</td>
										<td class="lable">FREE</td>
									</tr>
								</table>
							</td>
							<td class="hpr"><b>PRICE</b></td>
							<td  class="lable"><b>AMOUNT</b>
								<%-- <table>
									<tr>
										<td colspan="2"  class="lable">AMOUNT</td>
									</tr>
									<tr class="amnt_1">
										<td class="lable">RS.</td>
										<td class="lable">PS.</td>
									</tr>
								</table>--%>
							</td>
						</tr>
					<%int i=0; %>
					<c:set var="tot_qunty" value="0" scope="page"></c:set>
					<c:set var="count" value="0" scope="page"></c:set>
					<c:set var="grand_tot" value="0.00" scope="page"></c:set>
					<c:set var="overall_dis" value="0.00" scope="page"></c:set>
					<c:forEach items="${POLItems}" var="Item">
					<%i=i++; %>
						<tr>
							<c:set var="count" value="${count+1}" scope="page"></c:set>
							<td class="slno"><c:out value="${count}"></c:out></td>
							<td class="desc" colspan="2"><c:out value="${Item.productInventoryBean.productBean.name}"></c:out></td>
							<td class="sch"><c:out value="${Item.discount-PODetails.overallDiscount}"></c:out>%</td>
							<td class="mrp"><c:out value="${Item.netPrice}"></c:out></td>
							<td class="quta"><c:out value="${Item.quantity}"></c:out></td>
							<c:set var="tot_qunty" value="${tot_qunty+Item.quantity}" scope="page"></c:set>
							<td class="fquta"><c:out value="${Item.freeQantity}"></c:out></td>
							<td class="pr"><c:out value="${Item.unitPrice}"></c:out></td>
							<td class="amt" style="text-align: right;padding-right: 15px;"><c:out value="${Item.amount}"></c:out></td>
						<%-- 	<td class="amt" style="text-align: right;padding-right: 15px;"><c:out value="${Item.amount-((Item.amount)*((Item.discount-PODetails.overallDiscount)/100))}"></c:out></td>
							<td class="amt"><c:out value="${(Item.amount-(Item.amount*(Item.discount/100)))}"></c:out></td>
						<td class="ps"></td>--%>	
						<%-- <c:set var="grand_tot" value="${grand_tot+(Item.amount-((Item.amount)*((Item.discount-PODetails.overallDiscount)/100)))}" scope="page"></c:set>--%>	
						<c:set var="grand_tot" value="${grand_tot+Item.amount}" scope="page"></c:set>
						<c:set var="overall_dis" value="${overall_dis+(Item.amount*(PODetails.overallDiscount/100))}" scope="page"></c:set>
						</tr>
				</c:forEach>
				 
						<tr class="inv_items_footer_1">
							<tr class="inv_items_footer_1">
							
							<td colspan="5" class="lable" style="text-align: right;"><b>TOTAL QUANTITY:</b></td>
							<td  class="tot_qua"><c:out value="${tot_qunty}"></c:out></td>
							<td colspan="2" class="lable" style="text-align: right;">GRAND TOTAL:</td>
							<td class="grand_tot" style="text-align: right;padding-right: 15px;">${grand_tot}</td>
							
						</tr>
						<tr class="">
							<td colspan="5" style="text-align: right;">${vatDetails}</td>
							<td  class="tot_qua"></td>
						<%-- <td colspan="2" class="lable" style="text-align: right;">LESS DISCOUNT:</td>
							<td class="">${PODetails.discountPrice}</td>--%>	
							<td colspan="2" class="lable" style="text-align: right;">OVERALL DISCOUNT ${PODetails.overallDiscount}%:</td>
							<td class="ovr_dis" style="text-align: right;padding-right: 15px;">${overall_dis}</td>
						
						</tr>
						
						<tr class="">
							<td colspan="5"></td>
							<td  class="tot_qua"></td>
							<td colspan="2" class="lable" style="text-align: right;">ADD VAT :</td>
							<td class="tot_vat" style="text-align: right;padding-right: 15px;">${PODetails.totalVAT}</td>
							
						</tr>
						<tr class="" >
							<td colspan="2"><div class="lable" ></div></td>
							<td colspan="3" style="text-align: left;padding-left:5%;"></td>
							<td  class="tot_qua"></td>
							<td colspan="2" class="lable" style="text-align: right;">PAY AMOUNT:</td>
							<td class="pay_amnt" style="text-align: right;padding-right: 15px;">${PODetails.payAmount}</td>
							
						</tr>
						<tr class="" >
							<td colspan="2"><div class="lable" >In Words :</div></td>
							<td colspan="3" style="text-align: left;padding-left:5%;"><div>${POAmntInWords}&nbsp;Rupees&nbsp;Only/-</div></td>
							<td  class="tot_qua"></td>
							<td colspan="2" class="lable" style="text-align: right;">ROUNDED AMOUNT:</td>
							<td class="pay_amnt" style="text-align: right;padding-right: 15px;"><fmt:formatNumber type="number" 
            maxFractionDigits="" value="${PODetails.payAmount}" />.00</td>
							
						</tr>
			

						

					</table>
					<!---->
				</td>
			</tr>
	
			<tr class="inv_tc">
				<td>
					<table class="inv_tc_1">
						<tr>
							<td class="inv_tc_1_1">
								<table>
									<tr>
										<td class="lable">TERMS & CONDITIONS:</td>
									</tr>
									<tr>
										<td>
											<p>1.Goods once sold will not taken back or exchanged:<br>
											   2.Payments to be made within 15 days from date of invoice:<br>
											</p>
										</td>
									</tr>
								</table>
							</td>
							<td class="inv_tc_1_1"><b>RECIEVER'S SIGNATURE<BR> WITH SEAL</b>
							</td>
							<td class="lable">AUTHORISED SIGNATORY</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</div>
	</body>
	</html>