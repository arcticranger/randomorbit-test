<%@ page import="randomorbit.test.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userId', 'error')} required">
	<label for="userId">
		<g:message code="user.userId.label" default="User Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="userId" required="" value="${userInstance?.userId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${userInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'age', 'error')} required">
	<label for="age">
		<g:message code="user.age.label" default="Age" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="age" type="number" value="${userInstance.age}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'build', 'error')} required">
	<label for="build">
		<g:message code="user.build.label" default="Build" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="build" from="${randomorbit.test.BuildEnum?.values()}" keys="${randomorbit.test.BuildEnum.values()*.name()}" required="" value="${userInstance?.build?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'ethnic', 'error')} required">
	<label for="ethnic">
		<g:message code="user.ethnic.label" default="Ethnic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="ethnic" from="${randomorbit.test.EthnicEnum?.values()}" keys="${randomorbit.test.EthnicEnum.values()*.name()}" required="" value="${userInstance?.ethnic?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'hair', 'error')} required">
	<label for="hair">
		<g:message code="user.hair.label" default="Hair" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="hair" from="${randomorbit.test.HairEnum?.values()}" keys="${randomorbit.test.HairEnum.values()*.name()}" required="" value="${userInstance?.hair?.name()}"/>
</div>

