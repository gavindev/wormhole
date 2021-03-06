/*-
 * <<
 * wormhole
 * ==
 * Copyright (C) 2016 - 2017 EDP
 * ==
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
 * >>
 */

package edp.mad.persistence.entities

import edp.mad.persistence.base.{BaseEntity, BaseTable}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag

case class StreamCacheEntity(
                            id: Long,
                            streamId: Long,
                            streamName: String,
                             projectInfo: String,
                             streamInfo: String,
                             flowInfoList: String,
                             updateTime: String,
                             createTime: String
                           ) extends BaseEntity

class StreamCacheTable(_tableTag: Tag) extends BaseTable[StreamCacheEntity](_tableTag, "stream_cache") {
  def * = ( id, streamId, streamName, projectInfo, streamInfo, flowInfoList, updateTime, createTime ) <> (StreamCacheEntity.tupled, StreamCacheEntity.unapply)

  val streamId: Rep[Long] = column[Long]("stream_id")
  val streamName: Rep[String] = column[String]("stream_name", O.Length(5000, varying = true))
  val projectInfo: Rep[String] = column[String]("project_info", O.Length(5000, varying = true))
  val streamInfo: Rep[String] = column[String]("stream_info", O.Length(5000, varying = true))
  val flowInfoList: Rep[String] = column[String]("flow_info_list", O.Length(5000, varying = true))
  val updateTime: Rep[String] = column[String]("update_time", O.Length(5000, varying = true))
  val createTime: Rep[String] = column[String]("create_time", O.Length(5000, varying = true))

}
