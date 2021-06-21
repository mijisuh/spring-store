<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>
  <font color="darkgreen">Account Information</font>
</h3>

<table class="n13">
  <tr>
    <td>Name:</td>
    <td><form:input path="account.username" /><br>
      <form:errors path="account.username" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Email:</td>
    <td><form:input path="account.email" /><br>
      <form:errors path="account.email" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Phone:</td>
    <td><form:input path="account.phone" /><br>
      <form:errors path="account.phone" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Address 1:</td>
    <td><form:input path="account.address1" /><br>
      <form:errors path="account.address1" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Address 2:</td>
    <td><form:input path="account.address2" /><br>
      <form:errors path="account.address2" cssClass="error" /></td>
  </tr>
  <tr>
    <td>City:</td>
    <td><form:input path="account.city" /><br>
      <form:errors path="account.city" cssClass="error" /></td>
  </tr>
  <tr>
    <td>State:</td>
    <td><form:input path="account.state" /><br>
      <form:errors path="account.state" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Zipcode:</td>
    <td><form:input path="account.zip" /><br>
      <form:errors path="account.zip" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Country:</td>
    <td><form:input path="account.country" /><br>
      <form:errors path="account.country" cssClass="error" /></td>
  </tr>
</table>

<%-- <h3>
  <font color="darkgreen">Profile Information</font>
</h3>

<table class="n13" >
  <tr>
    <td>Language Preference:</td>
    <td><form:select path="account.languagePreference" items="${languages}" />
      <form:errors path="account.languagePreference" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Favorite Category:</td>
    <td><form:select path="account.favouriteCategoryId" items="${categories}" /> 
      <form:errors path="account.favouriteCategoryId" cssClass="error" /></td>
  </tr>
  <tr>
    <td colspan="2"><form:checkbox path="account.listOption" label="Enable MyList" /> 
      <form:errors path="account.listOption" cssClass="error" /></td>
  </tr>
  <tr>
    <td colspan="2"><form:checkbox path="account.bannerOption" label="Enable MyBanner" /> 
      <form:errors path="account.bannerOption" cssClass="error" /></td>
  </tr>
</table> --%>