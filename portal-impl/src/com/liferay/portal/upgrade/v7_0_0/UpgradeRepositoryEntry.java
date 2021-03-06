/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_0.util.RepositoryEntryTable;

import java.sql.SQLException;

/**
 * @author Sergio González
 */
public class UpgradeRepositoryEntry extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		try {
			runSQL(
				"alter_column_type RepositoryEntry mappedId VARCHAR(255) null");
		}
		catch (SQLException sqle) {
			upgradeTable(
				RepositoryEntryTable.TABLE_NAME,
				RepositoryEntryTable.TABLE_COLUMNS,
				RepositoryEntryTable.TABLE_SQL_CREATE,
				RepositoryEntryTable.TABLE_SQL_ADD_INDEXES);
		}
	}

}