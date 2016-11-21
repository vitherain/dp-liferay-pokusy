<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:defineObjects />

<portlet:actionURL var="actionUrl" name="submitPerson"/>

<aui:form name="person" method="post" action="${actionUrl}">

    <aui:input label="First name" name="firstName" value="${person.firstName}" />
    <aui:input label="Last name" name="lastName" value="${person.lastName}" />
    <aui:input label="Is active" name="active" checked="${person.active}" type="checkbox" />

    <button type="submit">Save</button>
</aui:form>