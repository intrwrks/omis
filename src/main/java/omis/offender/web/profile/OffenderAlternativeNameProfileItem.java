package omis.offender.web.profile;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import omis.offender.domain.Offender;
import omis.offender.report.AlternativeOffenderNameProfileItemReportService;
import omis.user.domain.UserAccount;
import omis.web.profile.AbstractProfileItem;
import omis.web.profile.ProfileItem;
import omis.web.profile.ProfileItemRegistry;

/**
 * Profile item for alternative offender names.
 *
 * @author Stephen Abson
 * @version 0.0.1
 * @since OMIS 3.0
 */
public class OffenderAlternativeNameProfileItem
		extends AbstractProfileItem
		implements ProfileItem {
	
	private static final long serialVersionUID = 1L;
	
	private final AlternativeOffenderNameProfileItemReportService
	alternativeOffenderNameProfileItemReportService;
	
	private static final String COUNT_MODEL_KEY
		= "alternativeOffenderNameCount";

	/**
	 * Instantiates profile item for alternative offender names.
	 * 
	 * @param requiredAuthorizations required authorizations
	 * @param includePage include page
	 * @param name name
	 * @param profileItemRegistry profile item registry
	 * @param alternativeOffenderNameProfileItemReportService report service
	 * for profile items for alternative offender names
	 * @param enabled whether enabled
	 */
	public OffenderAlternativeNameProfileItem(
			final Set<String> requiredAuthorizations,
			final String includePage,
			final String name,
			final ProfileItemRegistry profileItemRegistry,
			final AlternativeOffenderNameProfileItemReportService
			alternativeOffenderNameProfileItemReportService,
			final Boolean enabled) {
		super(requiredAuthorizations, includePage, name, profileItemRegistry,
				enabled);
		this.alternativeOffenderNameProfileItemReportService
			= alternativeOffenderNameProfileItemReportService;
	}

	/** {@inheritDoc} */
	@Override
	public void build(
			final Map<String, Object> modelMap,
			final Offender offender,
			final UserAccount userAccount,
			final Date date) {
		Integer count = this.alternativeOffenderNameProfileItemReportService
				.findAlternativeOffenderNameCountByOffenderAndDate(
						offender, date);
		modelMap.put(COUNT_MODEL_KEY, count);
	}
}