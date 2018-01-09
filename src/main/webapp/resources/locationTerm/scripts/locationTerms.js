/**
 * Location terms screen behavior.
 * 
 * @author Stephen Abson
 */
window.onload = function() {
	applyActionMenu(document.getElementById("actionMenuLink"));
	var locationTermsTableBody = document.getElementById("locationTerms");
	var rowLinks = locationTermsTableBody.getElementsByTagName("a");
	for (var rowLinkIndex = 0; rowLinkIndex < rowLinks.length; rowLinkIndex++) {
		var rowLink = rowLinks[rowLinkIndex];
		if (rowLink.getAttribute("class") != null && rowLink.getAttribute("class").indexOf("actionMenuItem") > -1) {
			applyActionMenu(rowLink, function() {
				applyRemoveLinkConfirmation();
			});
		}
	}
};