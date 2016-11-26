<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:defineObjects />

<portlet:actionURL var="actionUrl" name="submitFile"/>

<aui:form name="form" method="post" action="${actionUrl}" enctype="multipart/form-data">
    <aui:input label="File" name="file" type="file" />
    <button type="submit">Upload</button>
</aui:form>