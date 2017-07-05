/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.object.formatters;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import multichain.nativeimpl.object.Permission;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class GrantFormatter {
	public final  Permission formatPermission(String stringPermission) {
		final Gson gson = new GsonBuilder().create();

		final Permission permission = gson.fromJson(stringPermission, Permission.class);

		return permission;
	}

	public final  List<Permission> formatPermissionList(String stringPermission) {
		final Gson gson = new GsonBuilder().create();

		Type listType = new TypeToken<List<Permission>>(){}.getType();
		final List<Permission> permissionList = gson.fromJson(stringPermission, listType);

		return permissionList;
	}


}
