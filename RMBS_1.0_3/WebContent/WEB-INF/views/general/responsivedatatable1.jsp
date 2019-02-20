<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

<style>
/* 
Generic Styling, for Desktops/Laptops 
*/
table { 
  width: 100%; 
  border-collapse: collapse; 
}
/* Zebra striping */
tr:nth-of-type(odd) { 
  background: #eee; 
}
th { 
  background: #333; 
  color: white; 
  font-weight: bold; 
}
td, th { 
  padding: 6px; 
  border: 1px solid #ccc; 
  text-align: left; 
}


/* 
Max width before this PARTICULAR table gets nasty
This query will take effect for any screen smaller than 760px
and also iPads specifically.
*/
@media 
only screen and (max-width: 760px),
(min-device-width: 768px) and (max-device-width: 1024px)  {
 
    /* Force table to not be like tables anymore */
    table, thead, tbody, th, td, tr { 
        display: block; 
    }
     
    /* Hide table headers (but not display: none;, for accessibility) */
    thead tr { 
        position: absolute;
        top: -9999px;
        left: -9999px;
    }
     
    tr { border: 1px solid #ccc; }
     
    td { 
        /* Behave  like a "row" */
        border: none;
        border-bottom: 1px solid #eee; 
        position: relative;
        padding-left: 50%; 
    }
     
    td:before { 
        /* Now like a table header */
        position: absolute;
        /* Top/left values mimic padding */
        top: 6px;
        left: 6px;
        width: 45%; 
        padding-right: 10px; 
        white-space: nowrap;
    }
     
    /*
    Label the data
    */
  
}
</style>
</HEAD>

<BODY>
<table class="mediaTable">
			<thead>
				<tr>
					<th class="essential persist">Employee</th>
					<th class="essential">xHTML</th>
					<th class="optional">HTML5</th>
					<th class="essential">CSS</th>
					<th class="essential">JS</th>
					<th class="optional">jQuery</th>
					<th class="optional">jQueryUI</th>
					<th>jQuery Mobile</th>
					<th>Sencha Touch</th>
					<th class="essential">PHP</th>
					<th>PHP (OO)</th>
					<th class="optional">CakePHP</th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Marco Pegoraro</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
				</tr>
				<tr>
					<td>Mario Rossi</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="no">n</td>
					<td class="yes">y</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="yes">y</td>
					<td class="no">n</td>
				</tr>
				<tr>
					<td>Alberto Bianchi</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="yes">y</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="no">n</td>
					<td class="no">n</td>
				</tr>
			</tbody>
		</table>
</BODY>
</HTML>
