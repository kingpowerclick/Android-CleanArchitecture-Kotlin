/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.his.features.movies

import com.his.UnitTest
import com.his.features.movies.data.GetMovieDetails
import com.his.features.movies.data.MoviesRepository
import com.his.features.movies.view.model.MovieDetails
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetMovieDetailsTest : UnitTest() {

	private val MOVIE_ID = 1

	private lateinit var getMovieDetails: GetMovieDetails

	@Mock
	private lateinit var moviesRepository: MoviesRepository

	@Before
	fun setUp() {
		getMovieDetails = GetMovieDetails(moviesRepository)
		given { moviesRepository.movieDetails(MOVIE_ID) }.willReturn(Observable.just(MovieDetails.empty()))
	}

	@Test
	fun `should get data from repository`() {
		getMovieDetails.buildUseCase(GetMovieDetails.Params(MOVIE_ID))
			.subscribe()

		verify(moviesRepository).movieDetails(MOVIE_ID)
		verifyNoMoreInteractions(moviesRepository)
	}
}
