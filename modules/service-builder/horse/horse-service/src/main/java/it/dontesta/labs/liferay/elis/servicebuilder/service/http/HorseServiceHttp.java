/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.dontesta.labs.liferay.elis.servicebuilder.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.dontesta.labs.liferay.elis.servicebuilder.service.HorseServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link HorseServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HorseServiceSoap
 * @see HttpPrincipal
 * @see HorseServiceUtil
 * @generated
 */
@ProviderType
public class HorseServiceHttp {
	public static java.util.List<it.dontesta.labs.liferay.elis.servicebuilder.model.Horse> getHorses(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(HorseServiceUtil.class,
					"getHorses", _getHorsesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.dontesta.labs.liferay.elis.servicebuilder.model.Horse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static it.dontesta.labs.liferay.elis.servicebuilder.model.Horse getHorse(
		HttpPrincipal httpPrincipal, long horseId)
		throws it.dontesta.labs.liferay.elis.servicebuilder.exception.NoSuchHorseException {
		try {
			MethodKey methodKey = new MethodKey(HorseServiceUtil.class,
					"getHorse", _getHorseParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, horseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof it.dontesta.labs.liferay.elis.servicebuilder.exception.NoSuchHorseException) {
					throw (it.dontesta.labs.liferay.elis.servicebuilder.exception.NoSuchHorseException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (it.dontesta.labs.liferay.elis.servicebuilder.model.Horse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.dontesta.labs.liferay.elis.servicebuilder.model.Horse> getHorsesByName(
		HttpPrincipal httpPrincipal, java.lang.String name) {
		try {
			MethodKey methodKey = new MethodKey(HorseServiceUtil.class,
					"getHorsesByName", _getHorsesByNameParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.dontesta.labs.liferay.elis.servicebuilder.model.Horse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static it.dontesta.labs.liferay.elis.servicebuilder.model.Horse addHorse(
		HttpPrincipal httpPrincipal, java.lang.String name,
		java.lang.String kind, java.lang.String mantle,
		java.lang.String gender, int age) {
		try {
			MethodKey methodKey = new MethodKey(HorseServiceUtil.class,
					"addHorse", _addHorseParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, name,
					kind, mantle, gender, age);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (it.dontesta.labs.liferay.elis.servicebuilder.model.Horse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static it.dontesta.labs.liferay.elis.servicebuilder.model.Horse deleteHorse(
		HttpPrincipal httpPrincipal, long horseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(HorseServiceUtil.class,
					"deleteHorse", _deleteHorseParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, horseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (it.dontesta.labs.liferay.elis.servicebuilder.model.Horse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.dontesta.labs.liferay.elis.servicebuilder.model.Horse> getCurrentHorseByeAge(
		HttpPrincipal httpPrincipal, int age) {
		try {
			MethodKey methodKey = new MethodKey(HorseServiceUtil.class,
					"getCurrentHorseByeAge",
					_getCurrentHorseByeAgeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, age);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.dontesta.labs.liferay.elis.servicebuilder.model.Horse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.dontesta.labs.liferay.elis.servicebuilder.model.Horse> getHorsesByKind(
		HttpPrincipal httpPrincipal, java.lang.String kind) {
		try {
			MethodKey methodKey = new MethodKey(HorseServiceUtil.class,
					"getHorsesByKind", _getHorsesByKindParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, kind);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.dontesta.labs.liferay.elis.servicebuilder.model.Horse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(HorseServiceHttp.class);
	private static final Class<?>[] _getHorsesParameterTypes0 = new Class[] {  };
	private static final Class<?>[] _getHorseParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getHorsesByNameParameterTypes2 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _addHorseParameterTypes3 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class, int.class
		};
	private static final Class<?>[] _deleteHorseParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCurrentHorseByeAgeParameterTypes5 = new Class[] {
			int.class
		};
	private static final Class<?>[] _getHorsesByKindParameterTypes6 = new Class[] {
			java.lang.String.class
		};
}