/*
 * OMIS - Offender Management Information System
 * Copyright (C) 2011 - 2017 State of Montana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package omis.assessment.dao;

import java.util.List;
import omis.assessment.domain.AnswerRating;
import omis.assessment.domain.RatingCategory;
import omis.assessment.domain.RatingScaleGroup;
import omis.dao.GenericDao;
import omis.questionnaire.domain.AdministeredQuestionnaire;
import omis.questionnaire.domain.AllowedAnswer;

/**
 * Data access object for answer rating.
 * 
 * @author Josh Divine
 * @author Annie Wahl
 * @version 0.1.2 (Aug 14, 2018)
 * @since OMIS 3.0
 */
public interface AnswerRatingDao extends GenericDao<AnswerRating> {

	/**
	 * Returns the answer rating that matches the specified parameters.
	 * 
	 * @param allowedAnswer allowed answer
	 * @param ratingCategory rating category
	 * @return answer rating
	 */
	AnswerRating find(AllowedAnswer allowedAnswer,
			RatingCategory ratingCategory);
	
	/**
	 * Returns the answer rating that matches the specified parameters excluding
	 * the specified answer rating.
	 * 
	 * @param allowedAnswer allowed answer
	 * @param ratingCategory rating category
	 * @param excludedAnswerRating excluded answer rating
	 * @return answer rating
	 */
	AnswerRating findExcluding(AllowedAnswer allowedAnswer, 
			RatingCategory ratingCategory, AnswerRating excludedAnswerRating);

	/**
	 * Returns a list of answer ratings for the specified rating category and 
	 * administered questionnaire.
	 * 
	 * @param ratingCategory rating category
	 * @param administeredQuestionnaire administered questionnaire
	 * @return list of answer ratings
	 */
	List<AnswerRating> findByRatingCategoryAndAdministeredQuestionnaire(
			RatingCategory ratingCategory,
			AdministeredQuestionnaire administeredQuestionnaire);

	/**
	 * Returns a list of answer ratings for the specified scaled group and 
	 * administered questionnaire.
	 * 
	 * @param ratingScaleGroup rating scale group
	 * @param administeredQuestionnaire administered questionnaire
	 * @return list of answer ratings
	 */
	List<AnswerRating> findByRatingScaleGroupAndAdministeredQuestionnaire(
			RatingScaleGroup ratingScaleGroup,
			AdministeredQuestionnaire administeredQuestionnaire);

	/**
	 * Returns a list of answer ratings for the specified rating category and 
	 * administered questionnaire excluding already scaled groups.
	 * 
	 * @param ratingCategory rating category
	 * @param administeredQuestionnaire administered questionnaire
	 * @return list of answer ratings
	 */
	List<AnswerRating> 
			findByRatingCategoryAndAdministeredQuestionnaireExcludingScaledGroups(
					RatingCategory ratingCategory, 
					AdministeredQuestionnaire administeredQuestionnaire);
}