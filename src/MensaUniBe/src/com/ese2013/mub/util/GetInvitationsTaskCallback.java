package com.ese2013.mub.util;

import java.util.List;

import com.ese2013.mub.social.Invitation;

public interface GetInvitationsTaskCallback {
	public void onInvitesTaskFinished(List<Invitation> invitations);
}